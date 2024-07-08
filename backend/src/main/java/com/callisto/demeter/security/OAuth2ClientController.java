package com.callisto.demeter.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuth2ClientController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;


    @RequestMapping("/oauth2")
    public String oauth2() {
        ClientRegistration googleRegistration = this.clientRegistrationRepository.findByRegistrationId("google");
        return "index";
    }
}
