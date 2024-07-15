

export const Register = () => {
    {/* You can open the modal using document.getElementById('ID').showModal() method */ }
    return (
        <form method="get">
            {/* if there is a button in form, it will close the modal */}
            <div className="grid grid-cols-1 justify-items-center">
                <h3 className="font-bold text-3xl text-primary">Sign up</h3>
                <p className="py-4">Create an account to get started!</p>
                <label className="form-control w-full max-w-xs">
                    <div className="label">
                        <span className="label-text font-semibold">Username</span>
                    </div>
                    <input type="text" placeholder="Username" className="input input-bordered w-full max-w-xs" />
                    <div className="label">
                        <span className="label-text font-semibold">Password</span>
                    </div>
                    <input type="password" placeholder="Password" className="input bold input-bordered w-full max-w-xs" />
                    <div className="label">
                        <span className="label-text font-semibold">Confirm Password</span>
                    </div>
                    <input type="password" placeholder="Confirm Password" className="input bold input-bordered w-full max-w-xs" />
                    <div className="label">
                        <span className="label-text font-semibold">Display Name</span>
                    </div>
                    <input type="text" placeholder="Display Name" className="input input-bordered w-full max-w-xs" />
                    <div className="label">
                        <span className="label-text font-semibold">Email</span>
                    </div>
                    <input type="text" placeholder="email@something.com" className="input bold input-bordered w-full max-w-xs" />
                    <button className="btn mt-4 font-extrabold">Create an account</button>
                </label>
                <div className="label">
                    <span className="label-text font-semibold">
                        Already have an account?
                        <a href="/login" className="btn btn-link -ml-2">Login</a>
                    </span>
                </div>
            </div>
        </form>
    );
}