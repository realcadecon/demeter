import React from "react";
import { Navbar } from "../../layouts/NavbarAndFooter/Navbar";
import { HomePage } from "../../layouts/Landing/HomePage";
import { Footer } from "../../layouts/NavbarAndFooter/Footer";

export default function Page() {
  return (
    <div className="max-w-full flex flex-col justify-between h-screen">
      <Navbar showLogin={true} showSignUp={true}/>
      <HomePage />
      <Footer />
    </div>
  );
}
