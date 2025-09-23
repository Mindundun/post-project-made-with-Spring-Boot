package com.example.post_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.post_project.dto.ArticleDto;

// Mapper Interface
// SQL 매핑 : XML 또는 Annotation에 정의된 SQL 구문을 메소드와 매핑
@Mapper
public interface ArticleMapper {

    // 게시글 목록 조회
    List<ArticleDto> selectArticleList();

    // 게시글 등록
    void insertArticle(ArticleDto article);

    
}
