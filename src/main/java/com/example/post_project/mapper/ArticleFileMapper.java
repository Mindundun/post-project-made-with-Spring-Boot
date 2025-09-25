package com.example.post_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.post_project.dto.ArticleFileDto;

@Mapper
public interface ArticleFileMapper {
    // 파일 등록
    void insertArticleFile(List<ArticleFileDto> files); // 배치처리 예정.
}
