import { useState, useEffect } from "react";
import { DropDownIcon } from "../../assets/DropDownIcon";
import { MainLogo } from "../../assets/MainLogo";
import { ThemeSelector } from "../../components/ThemeSelector";
import { LoginModal } from "../Utils/LoginModal";



export const Navbar = (props: { showLogin?: boolean, showSignUp?: boolean, showUser?: boolean }) => {

    const [isDark, setIsDark] = useState(undefined);
    const [username, setUsername] = useState("");
    const [loadingButtons, setLoadingButtons] = useState(true);


    useEffect(() => {
        const savedTheme = JSON.parse(localStorage.getItem('isDark')!);
        setIsDark(savedTheme ? savedTheme : false);

    }, []);

    useEffect(() => {
        if (typeof isDark === "boolean") {
            localStorage.setItem('isDark', JSON.stringify(isDark));
        }
    }, [isDark]);

    useEffect(() => {
        if(props.showUser)  {
            const user = JSON.parse(localStorage.getItem("User")); 
            setUsername(user.username);
        }
        setLoadingButtons(false);
    }, [props.showUser])

    return (
        <div className="navbar bg-base-100 mb-6">
            <div className="navbar-start">
                <a href="/" className="btn btn-ghost text-xl text-primary">
                    <MainLogo />
                    Project Demeter
                </a>
            </div>
            <LoginModal />
            {/* Desktop */}
            <div className="navbar-center hidden lg:flex">
                <ul className="menu menu-horizontal px-1">
                    <li><a href="/">Home</a></li>
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
                    <ThemeSelector themeAlt="dracula" bDark={isDark == undefined ? undefined : isDark} setTheme={setIsDark} />
                </span>
                {props.showLogin &&
                    <a className="btn btn-ghost mr-1 hover:underline hidden lg:flex"
                        onClick={() => {
                            const modal = document.getElementById('my_modal_3') as HTMLDialogElement;
                            if (modal) {
                                modal.showModal();
                            }
                        }}>
                        Login
                    </a>
                }
                {props.showSignUp &&
                    <a className={`btn btn-primary hidden lg:flex ${!props.showLogin ? 'ml-2' : ''}`} href="register">
                        Sign Up
                    </a>
                }
                {props.showUser &&
                    <a className={`hidden lg:flex ml-2`} href="meal">
                        <div className="avatar placeholder">
                            <div className="bg-neutral text-neutral-content w-10 rounded-full">
                                <span>{username != "" ? username[0].toUpperCase() : "X"}</span>
                            </div>
                        </div>
                    </a>
                }
                {/* Mobile */}
                <div className="dropdown dropdown-left dropdown-hover">
                    <div tabIndex={0} role="button" className="btn btn-ghost lg:hidden">
                        <DropDownIcon />
                    </div>
                    <ul tabIndex={0} className="menu menu-sm dropdown-content mt-3 z-[1] p-2 shadow bg-base-100 rounded-box w-52">
                        <li>
                            <a href="/">Home</a>
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
                        {props.showLogin &&
                            <li>
                                <a className="btn btn-ghost mt-2 mb-2 hover:underline" onClick={() => {
                                    const modal = document.getElementById('my_modal_3') as HTMLDialogElement;
                                    if (modal) {
                                        modal.showModal();
                                    }
                                }}>
                                    Login
                                </a>
                            </li>
                        } 
                        {props.showSignUp &&
                            <li>
                                <a className={`btn btn-primary mb-2 ${!props.showLogin ? 'mt-2' : ''}`} href="register">Sign Up</a>
                            </li>
                        }
                        <li>
                            <ThemeSelector themeAlt="dracula" bDark={isDark == undefined ? undefined : isDark} setTheme={setIsDark} />
                        </li>
                    </ul>
                </div>
            </div>
        </div >
    );
}