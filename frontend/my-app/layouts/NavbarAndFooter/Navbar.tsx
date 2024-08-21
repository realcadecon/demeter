import { useState, useEffect } from "react";
import { DropDownIcon } from "../../assets/DropDownIcon";
import { MainLogo } from "../../assets/MainLogo";
import { ThemeSelector } from "../../components/ThemeSelector";
import { LoginModal } from "../Utils/LoginModal";
import { navigate } from "vike/client/router";



export const Navbar = (props: { showLogin?: boolean, showSignUp?: boolean, showUser?: boolean }) => {

    const [isDark, setIsDark] = useState(undefined);
    const [username, setUsername] = useState("");
    const [loginStatus, setLoginStatus] = useState(props.showLogin);
    const [signupStatus, setSignupStatus] = useState(props.showSignUp);
    const [userStatus, setUserStatus] = useState(props.showUser);


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
        const userValue = localStorage.getItem("User")
        if (userValue != null) {
            const user = JSON.parse(userValue);
            setUsername(user.username);
            setUserStatus(true);
            setLoginStatus(false);
            setSignupStatus(false);
        }
    }, [userStatus])

    const handleSignOut = () => {
        console.log("signing out");
        localStorage.removeItem("User");
        localStorage.removeItem("JWT");
        setUserStatus(false);
        setLoginStatus(true);
        setSignupStatus(true);
        setUsername("");
        navigate("/");
    }

    return (
        <div className="navbar bg-base-100 mb-6">
            <div className="navbar-start">
                <a href="/" className="btn btn-ghost text-xl text-primary">
                    <MainLogo fillClass="fill-primary" />
                    Project Demeter
                </a>
            </div>
            {/* <LoginModal /> */}
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
                {loginStatus &&
                    <a className="btn btn-ghost mr-1 hover:underline hidden lg:flex"
                        // onClick={() => {
                        //     const modal = document.getElementById('my_modal_3') as HTMLDialogElement;
                        //     if (modal) {
                        //         modal.showModal();
                        //     }
                        // }}
                        href="/login">
                        Login
                    </a>
                }
                {signupStatus &&
                    <a className={`btn btn-primary hidden lg:flex ${!loginStatus ? 'ml-2' : ''}`} href="/register">
                        Sign Up
                    </a>
                }
                {userStatus &&
                    <div className="hidden lg:dropdown dropdown-bottom dropdown-end dropdown-hover">
                        <div tabIndex={0} className="avatar placeholder btn btn-ghost" role="button">
                            <div className="btn btn-sm btn-circle btn-outline pr-[0.1rem]">
                                {username != "" ? username[0].toUpperCase() : "X"}
                            </div>
                        </div>
                        <ul tabIndex={0} className="menu dropdown-content z-[1] p-2 shadow-xl bg-base-100 rounded-box w-32">
                            <li className="p-1">
                                <a className="btn btn-primary btn-sm" href="/meal">
                                    Meals
                                </a>
                            </li>
                            <li className="p-1">
                                <div onClick={handleSignOut} className="btn btn-sm btn-outline btn-primary">Sign Out</div>
                            </li>
                        </ul>
                    </div>
                }



                {/* Mobile */}
                <div className="dropdown dropdown-left dropdown-hover">
                    <div tabIndex={0} role="button" className="btn btn-ghost lg:hidden">
                        <DropDownIcon />
                    </div>
                    <ul tabIndex={0} className="menu menu-sm dropdown-content mt-2 z-[1] p-2 shadow drop-shadow-lg bg-base-100 rounded-box w-52">
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
                        {loginStatus &&
                            <li>
                                <a className="btn btn-ghost mt-2 mb-2 hover:underline" href="/login"
                                // onClick={() => {
                                //     const modal = document.getElementById('my_modal_3') as HTMLDialogElement;
                                //     if (modal) {
                                //         modal.showModal();
                                //     }
                                // }}
                                >
                                    Login
                                </a>
                            </li>
                        }
                        {signupStatus &&
                            <li>
                                <a className={`btn btn-primary mb-2 ${!loginStatus ? 'mt-2' : ''}`} href="/register">Sign Up</a>
                            </li>
                        }
                        {userStatus &&
                            <li className="p-1">
                                <a className="btn btn-primary btn-sm" href="/meal">
                                    Meals
                                </a>
                            </li>
                        }
                        {userStatus && 
                            <li className="p-1">
                                <div onClick={handleSignOut} className="btn btn-sm btn-outline btn-primary">Sign Out</div>
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