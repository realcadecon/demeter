import { Github } from "../../assets/SocialIcons/Github";

export const OAuthLogin = () => {

    const handleGithubLogin = async () => {
        try {
            const res = await fetch("http://localhost:8080/login/oauth2/code/github");
            const resJson = await res.json();
            window.location.href = resJson.redirectUrl;
        }
        catch(error) {
            console.error("Error initiating github login");
        }
    };


    return (
        <a className="flex btn btn-primary" onClick={handleGithubLogin}>
            Login with Github
            <Github />
        </a>
    );
}