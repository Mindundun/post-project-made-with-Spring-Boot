package com.example.post_project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.service.ArticleService;
// import com.mysql.cj.protocol.x.Ok;

import lombok.RequiredArgsConstructor;

// @ResponseBody + @Controller
@RestController // Rest API 사용 시 
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ArticleController {
    // field
    private final ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        List<ArticleDto> articles = articleService.retrieveArticleList();

        // ResponseEntity는 HttpResponse
        // return ResponseEntity.ok().body(articles);              // builder pattern
        return new ResponseEntity<>(articles, HttpStatus.OK);   // 객체 생성
    }

    // Map<String, Integer로 리턴타입을 갖는 이유 : json과 같이 {"key" : value}    
    @PostMapping("/articles")
    public ResponseEntity<Map<String, Integer>> postArticle(@RequestBody ArticleDto article) {
        int id = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("id",id)); // builder pattern
    }
}
