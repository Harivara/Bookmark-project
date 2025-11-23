import Link from "next/link";
import React from "react";
import { Singlebookmark } from "../services/models";

interface BookmarkProps {
    bookmark: Singlebookmark;
}

const Bookmark: React.FC<BookmarkProps> = ({ bookmark }) => (
    <div>
        <div className="alert alert-primary" role="alert">
            <h5>
                <Link
                    href={bookmark.url}
                    target="_blank"
                    className="text-decoration-none"
                >
                    {bookmark.title}
                </Link>
            </h5>
        </div>
    </div>
);

export default Bookmark;
