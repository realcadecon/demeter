// import { authClient } from "./client";

// export const welcomePage = async (): Promise<any> => {
//     const { data } = await authClient.get('/welcome');
//     return data;
// }

// export const attemptLogin = async (user: string, pass: string) => {
//     const body = {
//         username: user,
//         password: pass,
//     };
//     const res = await authClient.post('generateToken', body)
//     .then(data => {
//         console.log("Success: " + data);
//         return data;
//     })
//     .catch(error => {
//         console.log("Error: " + error.message);
//         return error;
//     });
//     return res;
// }


// export const testPost = async (name: string) => {
//     const body = {
//         name: name
//     };

//     const { data } = await authClient.post('test', JSON.stringify(body));
//     return data;
// }