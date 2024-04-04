import { useState } from "react";
import { DropDownIcon } from "../../assets/DropDownIcon";
import { MainLogo } from "../../assets/MainLogo";
import { ThemeSelector } from "../../components/ThemeSelector";
import { LoginModal } from "../Utils/LoginModal";
export const Navbar = () => {

    let [showLogin, setShowLogin] = useState(false);


    return (
        <div className="navbar bg-base-100 mb-6">
            <div className="navbar-start">
                <a className="btn btn-ghost text-xl text-primary">
                    <MainLogo />
                    Project Demeter
                </a>
            </div>
            {/* Desktop */}
            <div className="navbar-center hidden lg:flex">
                <ul className="menu menu-horizontal px-1">
                    <li><a>Home</a></li>
                    <li><a>About</a></li>
                    <li>
                        <details>
                            <summary>Helpful Tools</summary>
                            <ul className="p-2">
                                <li><a>Macronutriet Calculator</a></li>
                                <li><a>Personal Blog</a></li>
                            </ul>
                        </details>
                    </li>
                </ul>
            </div>
            <div className="navbar-end">
                <span className="hidden lg:flex mr-1">
                    <ThemeSelector themeAlt="dracula" />
                </span>
                <a className="btn btn-ghost mr-1 hover:underline hidden lg:flex" 
                    onClick={() => document.getElementById('my_modal_3').showModal()}>
                    Login
                </a>
                <LoginModal />
                <a className="btn btn-primary hidden lg:flex">Sign Up</a>
                {/* Mobile */}
                <div className="dropdown dropdown-left dropdown-hover">
                    <div tabIndex={0} role="button" className="btn btn-ghost lg:hidden">
                        <DropDownIcon />
                    </div>
                    <ul tabIndex={0} className="menu menu-sm dropdown-content mt-3 z-[1] p-2 shadow bg-base-100 rounded-box w-52">
                        <li>
                            <a>Home</a>
                        </li>
                        <li>
                            <a>About</a>
                        </li>
                        <li>
                            <details>
                                <summary>
                                    <a>Helpful Tools</a>
                                </summary>
                                <ul>
                                    <li>
                                        <a>Macronutriet Calculator</a>
                                    </li>
                                    <li>
                                        <a>Personal Blog</a>
                                    </li>
                                </ul>
                            </details>
                        </li>
                        <li>
                            <a className="btn btn-ghost mt-2 mb-2 hover:underline" onClick={() => setShowLogin(!showLogin)}>Login</a>
                            {showLogin &&
                                <LoginModal />
                            }
                        </li>
                        <li>
                            <a className="btn btn-primary mb-2">Sign Up</a>
                        </li>
                        <li className="">
                            <ThemeSelector themeAlt="dracula" />
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    );
}