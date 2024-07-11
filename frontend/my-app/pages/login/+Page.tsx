import React from "react";
import { Navbar } from "../../layouts/NavbarAndFooter/Navbar";
import { Footer } from "../../layouts/NavbarAndFooter/Footer";
import { Login } from "../../layouts/Utils/Login";

export default function Page() {
  return (
    <div className="max-w-full flex flex-col justify-between h-screen">
      <Navbar showLogin={false} showSignUp={true}/>
      <Login />
      <Footer />
    </div>
  );
}
