import axios from "axios"
import {BookmarksResponse} from "./models";
// import getConfig from 'next/config'
// const { serverRuntimeConfig, publicRuntimeConfig } = getConfig()
//
// const getApiUrl = () => {
//     return serverRuntimeConfig.API_BASE_URL || publicRuntimeConfig.API_BASE_URL;
// }

const API_BASE_URL= "http://localhost:8081"

export const fetchBookmarks = async (page: number, query: string): Promise<BookmarksResponse> => {
    let url = `${API_BASE_URL}/api/bookmarks?page=${page}`
    if(query) {
        url += `&query=${query}`
    }
    const res = await axios.get<BookmarksResponse>(url)
    return res.data
}

export const saveBookmark = async (bookmark:{title: string, url: string}) => {
    const res = await axios.post(`${API_BASE_URL}/api/bookmarks`, bookmark)
    return res.data
}