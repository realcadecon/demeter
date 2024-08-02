import { useState, useEffect } from "react";
// import { getPosts, createPost } from "../../server/getData";
import { Navbar } from "../../layouts/NavbarAndFooter/Navbar";
import { Footer } from "../../layouts/NavbarAndFooter/Footer";
// import { ResponseAPI } from "../../server/client";
// import { welcomePage } from "../../server/authReqs";

export default function Page() {

  // const [posts, setPosts] = useState<ResponseAPI[]>([]);

  const [demeterData, setDemeterData] = useState<any>();

  const [bShowLogin, setbShowLogin] = useState(true);
  const [bShowSignUp, setbShowSignUp] = useState(true);
  const [bShowUser, setbShowUser] = useState(false);

  useEffect(() => {

    if(localStorage.getItem("User")) {
      setbShowLogin(false);
      setbShowSignUp(false);
      setbShowUser(true);
    }

    // getPosts().then(data => setPosts(data));
    // welcomePage().then(data => setDemeterData(data));

  }, [])

  // const handleClick = async () => {
  //   const newPost = await createPost("new title", "something", Date.now())
  //   setPosts(prev => ([newPost, ...prev]))
  // }

  return (
    <div className="max-w-full flex flex-col justify-between h-screen">
      <Navbar showLogin={bShowLogin} showSignUp={bShowSignUp} showUser={bShowUser}/>
      <div className="mx-10">

        <h1>Create Post 👇</h1>
        {/* <button onClick={handleClick}>Add Post</button> */}

        <br />
        <br />
        <h1>Get Post 👇</h1>
        <h2>posts list</h2>

        {/* <div className='grid'>
          {
            posts.map(post => (
              <div key={post.id}>
                <p className="text-primary">Title: <span className="text-accent">{post.title}</span></p>
                <p className="text-primary">Body: <span className="text-accent">{post.body}</span></p>
                <p className="text-primary">User: <span className="text-accent">{post.userId}</span></p>
              </div>
            ))
          }
        </div> */}

        <div>
          {demeterData}
        </div>

      </div>
      <Footer />
    </div>
  );
}
