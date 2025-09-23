package com.example.post_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.mapper.ArticleMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 아래의 생성자 + @Autowired 코드와 같은 처리를 함
public class ArticleService {
    // field
    private final ArticleMapper articleMapper;

    // @Autowired
    // public ArticleService(ArticleMapper articleMapper) {
    //     this.articleMapper = articleMapper;
    // }

    // 게시글 목록 조회
    public List<ArticleDto> retrieveArticleList() {
        return articleMapper.selectArtivcleList();        
    }
}
