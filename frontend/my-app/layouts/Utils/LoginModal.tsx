

export const LoginModal = () => {
    {/* You can open the modal using document.getElementById('ID').showModal() method */ }
    return (
        <dialog id="my_modal_3" className="modal">
            <div className="modal-box">
                <form method="dialog">
                    {/* if there is a button in form, it will close the modal */}
                    <button className="btn btn-sm btn-circle btn-ghost absolute right-2 top-2">✕</button>
                    <div className="grid grid-cols-1 justify-items-center">
                        <h3 className="font-bold text-3xl text-primary">Login</h3>
                        <p className="py-4">Welcome back! Please enter your details.</p>
                        <label className="form-control w-full max-w-xs">
                            <div className="label">
                                <span className="label-text font-semibold">Username</span>
                            </div>
                            <input type="text" placeholder="Username" className="input input-bordered w-full max-w-xs" />
                            <div className="label">
                                <span className="label-text font-semibold">Password</span>
                            </div>
                            <input type="password" placeholder="Password" className="input bold input-bordered w-full max-w-xs" />
                            <button className="btn mt-4">Login</button>
                        </label>
                        <div className="label">
                            <span className="label-text font-semibold">
                                Don't have an account?
                                <a href="/register" className="btn btn-link -ml-2">Sign Up!</a>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
        </dialog>
    );
}