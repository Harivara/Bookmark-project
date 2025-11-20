package org.example.bookmarkapi.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository repository;



/*
   ---------------------------Returning Bookmark Page-------------------------------------
   public BookmarksDTO getbookMarks(Integer page) {
       int pageNo=page<=0?1:page-1;
       Pageable pageable=PageRequest.of(pageNo,10,Sort.by(Sort.Direction.DESC,"createdAt"));
       Page<Bookmark> bookmarkPage=repository.findAll(pageable);
       return new BookmarksDTO(bookmarkPage);
   }
*/

 /*
       ---------------------------Returning BookmarkDTO Page-------------------------------------
            Page<type> is changed from Bookmark to BookmarkDTO in BookmarksDTO
            We need mapper for this
       ------------------------------------------------------------------------------------------
    public BookmarksDTO getbookMarks(Integer page) {
        int pageNo=page<=0?1:page-1;
        Pageable pageable=PageRequest.of(pageNo,10,Sort.by(Sort.Direction.DESC,"createdAt"));
        Page<BookmarkDTO> bookmarkPage=repository.findAll(pageable).map(bookmark -> bookmarkMapper.toDTO(bookmark));
        return new BookmarksDTO(bookmarkPage);
    }
  */


 /*
    -----------------------Returning  only the required feilds in Entity using JPA query---------
    ---------------We dont need mapper for this as mapping is done in the query itself -----------
  */
    public BookmarksDTO getbookMarks(Integer page) {
        int pageNo=page<=0?1:page-1;
        Pageable pageable=PageRequest.of(pageNo,10,Sort.by(Sort.Direction.DESC,"createdAt"));
        Page<BookmarkDTO> bookmarkPage=repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkPage);
    }




//    private final BookmarkMapper bookmarkMapper;

//    @Transactional(readOnly = true)
//    public BookmarksDTO getBookmarks(Integer page) {
//        int pageNo = page < 1 ? 0 : page -1 ;
//        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//        Page<BookmarkDTO> bookmarkPage = repository.findBy(pageable);
//        return new BookmarksDTO(bookmarkPage);
//    }

//    @Transactional(readOnly = true)
//    public BookmarksDTO searchBookmarks(String query, Integer page) {
//        int pageNo = page < 1 ? 0 : page -1 ;
//        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
//        //Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(query, pageable);
//        Page<BookmarkDTO> bookmarkPage = repository.findByTitleContainsIgnoreCase(query, pageable);
//        return new BookmarksDTO(bookmarkPage);
//    }
//
//    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
//        Bookmark bookmark = new Bookmark(null, request.getTitle(), request.getUrl(), Instant.now());
//        Bookmark savedBookmark = repository.save(bookmark);
//        return bookmarkMapper.toDTO(savedBookmark);
//    }
}