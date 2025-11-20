package org.example.bookmarkapi.domain;


import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
     public BookmarkDTO toDTO(Bookmark bookmark) {
         BookmarkDTO dto=new BookmarkDTO();
         dto.setId(bookmark.getId());
         dto.setTitle(bookmark.getTitle());
         dto.setUrl(bookmark.getUrl());
         dto.setCreateAt(bookmark.getCreatedAt());


         return  dto;
     }
}
