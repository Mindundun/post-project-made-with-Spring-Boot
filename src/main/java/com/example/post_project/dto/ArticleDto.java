package com.example.post_project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleDto {
    // field, property
    private int id;
    private String title;
    private String writer;
    private String contents;
    private LocalDateTime regDate;

    // 1 : N 관계 
    List<ArticleFileDto> files = new ArrayList<>();
}
