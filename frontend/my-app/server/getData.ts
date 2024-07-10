import { client, authClient, ResponseAPI, UserDemeter } from "./client";

export const getPosts = async (): Promise<ResponseAPI[]> => {
    const { data } = await client.get('?_limit=3');
    return data;
}

export const createPost = async (title: string, body: string, userId: number): Promise<ResponseAPI> => {
    const { data } = await client.post('')
    return data;
}

export const welcomePage = async (): Promise<any> => {
    const { data } = await authClient.get('/welcome');
    return data;
}