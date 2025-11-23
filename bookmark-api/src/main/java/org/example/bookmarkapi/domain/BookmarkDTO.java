package org.example.bookmarkapi.domain;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class BookmarkDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
}
