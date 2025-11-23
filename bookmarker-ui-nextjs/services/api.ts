import axios from "axios"
import {BookmarksResponse} from "./models";


const serverApi = process.env.SERVER_SIDE_API_BASE_URL;
const clientApi = process.env.CLIENT_SIDE_API_BASE_URL;

const getApiUrl = () => {
    if (typeof window === "undefined") {
        // Server-side (SSR)
        return serverApi!;
    }
    // Browser
    return clientApi!;
};

const API_BASE_URL= "http://localhost:8081"

export const fetchBookmarks = async (page: number, query: string): Promise<BookmarksResponse> => {
    let url = `${getApiUrl()}/api/bookmarks?page=${page}`
    if(query) {
        url += `&query=${query}`
    }
    const res = await axios.get<BookmarksResponse>(url)
    return res.data
}

export const saveBookmark = async (bookmark:{title: string, url: string}) => {
    const res = await axios.post(`${getApiUrl()}/api/bookmarks`, bookmark)
    return res.data
}