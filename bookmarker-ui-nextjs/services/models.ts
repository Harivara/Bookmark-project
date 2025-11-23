export interface BookmarksResponse {
    data: Singlebookmark[],
    totalElements: number,
    currentPage: number,
    totalPages: number,
    isFirst: boolean,
    isLast: boolean,
    hasNext: boolean,
    hasPrevious: boolean
}

export interface Singlebookmark {
    id: number,
    title: string,
    url: string,
    created_at: Date,
    updated_at: Date
}
