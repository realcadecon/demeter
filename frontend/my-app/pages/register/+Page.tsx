import { useEffect, useState } from "react";
import { Navbar } from "../../layouts/NavbarAndFooter/Navbar";
import { Footer } from "../../layouts/NavbarAndFooter/Footer";
import { Register } from "../../layouts/Utils/Register";

export default function Page() {

  const [bShowLogin, setbShowLogin] = useState(true);
  const [bShowSignUp, setbShowSignUp] = useState(true);
  const [bShowUser, setbShowUser] = useState(false);

  useEffect(() => {
    if(localStorage.getItem("User")) {
      setbShowLogin(false);
      setbShowSignUp(false);
      setbShowUser(true);
    }
  }, []);


  return (
    <div className="max-w-full flex flex-col justify-between h-screen">
      <Navbar showLogin={bShowLogin} showSignUp={bShowSignUp} showUser={bShowUser}/>
      <div>
        <Register />
      </div>
      <Footer />
    </div>
  );
}
