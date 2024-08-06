import { MainLogo } from "../../assets/MainLogo";
import { Facebook } from "../../assets/SocialIcons/Facebook";
import { Twitter } from "../../assets/SocialIcons/Twitter"
import { Youtube } from "../../assets/SocialIcons/Youtube"

export const Footer = () => {
    return (
        <footer className="footer footer-center p-10 mt-5 lg:mt-0 bg-primary text-primary-content fill-bas">
            <aside>
                <MainLogo fillClass="fill-primary-content" width={50}/>
                <p className="font-bold">
                    Project Demeter
                </p>
                <p>Copyright © 2024 - All right reserved</p>
            </aside>
            <nav>
                <div className="grid grid-flow-col gap-4">
                    <Twitter />
                    <Youtube />
                    <Facebook />
                </div>
            </nav>
        </footer>
    );
}