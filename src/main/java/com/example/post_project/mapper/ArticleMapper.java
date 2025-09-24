package com.example.post_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.dto.Criteria;

// Mapper Interface
// SQL 매핑 : XML 또는 Annotation에 정의된 SQL 구문을 메소드와 매핑
@Mapper
public interface ArticleMapper {

    // 게시글 목록 조회
    // 다수의 ArticleDto라 List로
    List<ArticleDto> selectArticleList();

    // 게시글 등록
    void insertArticle(ArticleDto article);

    // 게시글 상세 조회
    // 해당하는 id의 ArticleDto 객체
    ArticleDto selectArticleById(int id);

    // 게시글 수정
    void updateArticle(ArticleDto articleDto);

    // 게시글 삭제
    void deleteArticle(int id);

    // 게시글 검색
    List<ArticleDto> findArticleList(Criteria criteria);
    
}
