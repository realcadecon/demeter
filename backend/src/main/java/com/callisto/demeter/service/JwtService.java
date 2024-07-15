package com.callisto.demeter.service;

import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/*
*
* This class is responsible for generating, consuming, and validating JWT tokens for the backend.
*
*/
@Component
public class JwtService {

    private RsaJsonWebKey rsaJsonWebKey;
    private JwtConsumer jwtConsumer;

    public JwtService() throws JoseException {
        rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        // Give the JWK a Key ID (kid), which is just the polite thing to do
        rsaJsonWebKey.setKeyId("k1");

        jwtConsumer = new JwtConsumerBuilder()
                .setRequireExpirationTime() // the JWT must have an expiration time
                .setAllowedClockSkewInSeconds(30) // allow some leeway in validating time based claims to account for clock skew
                .setRequireSubject() // the JWT must have a subject claim
                .setExpectedIssuer("Issuer") // whom the JWT needs to have been issued by
                .setExpectedAudience("Audience") // to whom the JWT is intended for
                .setVerificationKey(rsaJsonWebKey.getKey()) // verify the signature with the public key
                .setJwsAlgorithmConstraints( // only allow the expected signature algorithm(s) in the given context
                        AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256) // which is only RS256 here
                .build(); // create the JwtConsumer instance
    }

    public String generateJWTToken(String username) throws JoseException {
        // Create the Claims, which will be the content of the JWT
        JwtClaims claims = new JwtClaims();
        claims.setIssuer("Issuer");  // who creates the token and signs it
        claims.setAudience("Audience"); // to whom the token is intended to be sent
        claims.setExpirationTimeMinutesInTheFuture(1000); // time when the token will expire (10 minutes from now)
        claims.setGeneratedJwtId(); // a unique identifier for the token
        claims.setIssuedAtToNow();  // when the token was issued/created (now)
        claims.setNotBeforeMinutesInThePast(2); // time before which the token is not yet valid (2 minutes ago)
        claims.setSubject("subject"); // the subject/principal is whom the token is about
        claims.setClaim("username", username); // additional claims/attributes about the subject can be added
        List<String> groups = Arrays.asList("group-one", "other-group", "group-three");
        claims.setStringListClaim("groups", groups); // multivalued claims work too and will end up as a JSON array

        // A JWT is a JWS and/or a JWE with JSON claims as the payload.
        JsonWebSignature jws = new JsonWebSignature();

        // The payload of the JWS is JSON content of the JWT Claims
        jws.setPayload(claims.toJson());

        // Sign JWT using the private key and id the key
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());

        // Use RSA_SHA256 Algorithm to protect integrity of claims
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        String jwt = jws.getCompactSerialization();

        System.out.println("JWT: " + jwt);

        return jwt;
    }

    public String extractUsername(String jwt) throws MalformedClaimException {
        JwtClaims jwtClaims;
        try {
            jwtClaims = validateToken(jwt);
        } catch (MalformedClaimException e) {
            return "cannot extract username from claims due to malformed claims";
        }
        String username = jwtClaims.getClaimValueAsString("username");
        if(username == null) {
            return "cannot find the claim: 'username'";
        }
        return username;
    }

    public Boolean checkIfUsernameMatchesToken(String jwt, UserDetails userDetails) throws MalformedClaimException {
        String username = extractUsername(jwt);
        return username != null && username.equals(userDetails.getUsername());
    }

    public JwtClaims validateToken(String jwt) throws MalformedClaimException {
        try
        {
            //  Validate the JWT and process it to the Claims
            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            System.out.println("JWT validation succeeded! " + jwtClaims);

            return jwtClaims;
        }
        catch (InvalidJwtException e) {
            // InvalidJwtException will be thrown, if the JWT failed processing or validation in any way.
            System.out.println("Invalid JWT! " + e);

            // Whether the JWT has expired being one common reason for invalidity
            if (e.hasExpired()) {
                System.out.println("JWT expired at " + e.getJwtContext().getJwtClaims().getExpirationTime());
            }
            // Or maybe the audience was invalid
            if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID)) {
                System.out.println("JWT had wrong audience: " + e.getJwtContext().getJwtClaims().getAudience());
            }
            throw new MalformedClaimException(e.getMessage());
        }
    }

}
