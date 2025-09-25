package com.example.post_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleFileDto {
    // field, property
    private int id;
    private String fileName;
    private String filePath;
    private long fileSize;
    private int articleId;

    
}
