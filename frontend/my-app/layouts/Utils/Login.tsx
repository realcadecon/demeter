import { useEffect, useState } from "react";
import { attemptLogin, testPost } from "../../server/authReqs";
import { navigate } from 'vike/client/router'

export const Login = () => {
    {/* You can open the modal using document.getElementById('ID').showModal() method */ }

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const [loginError, setLoginError] = useState<string | null>(null);

    const handleLoginClick = async () => {
        //fill login object 
        setLoginError(null);
        const loginRes = await attemptLogin(username, password);
        // const res = await testPost("role_test");
        if (loginRes.response) {
            if (loginRes.response.data) {
                setLoginError(loginRes.response.data.message);
            } else {
                setLoginError("Something unexpected happened. Please try again.");
            }
        } else {
            const user = {
                username: username,
            }
            localStorage.setItem('JWT', JSON.stringify(loginRes.data));
            localStorage.setItem('User', JSON.stringify(user));
            navigate('/meal');
        }
    }


    return (
        <div>
            {/* if there is a button in form, it will close the modal */}
            <div className="grid grid-cols-1 justify-items-center">
                <h3 className="font-bold text-3xl text-primary">Login</h3>
                <p className="py-4">Welcome back! Please enter your details.</p>
                <label className="form-control w-full max-w-xs">
                    {loginError &&
                        <div className="label-text text-error text-center"> { loginError } </div>
                    }
                    <div className="label">
                        <span className="label-text font-semibold">Username</span>
                    </div>
                    <input type="text" placeholder="Username" onChange={event => setUsername(event.target.value)} className="input input-bordered w-full max-w-xs" />
                    <div className="label">
                        <span className="label-text font-semibold">Password</span>
                    </div>
                    <input type="password" placeholder="Password" onChange={event => setPassword(event.target.value)} className="input bold input-bordered w-full max-w-xs" />
                    <button className="btn mt-4 font-extrabold" onClick={handleLoginClick}>Login</button>
                </label>
                <div className="label">
                    <span className="label-text font-semibold">
                        Don't have an account?
                        <a href="/register" className="btn btn-link -ml-2">Sign Up!</a>
                    </span>
                </div>
            </div>
        </div>
    );
}