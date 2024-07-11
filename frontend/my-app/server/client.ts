import axios from 'axios';

export const client = axios.create({
    baseURL: "https://jsonplaceholder.typicode.com/posts"
});

export const authClient = axios.create({
    baseURL: "http://localhost:8080/auth/",
    headers: {
        'Content-Type': 'application/json'
    }
});

export default axios.create({
    baseURL: "http://localhost:8080/auth/",
    headers: {
        'Content-Type': 'application/json'
    }
});


export interface UserDemeter {
    username: string;
    password: string;
    firstName: string;
    email: string;
    roles: {name: string}[];
}

export interface ResponseAPI {
    userId: number;
    id: number;
    title: string;
    body: string;
}