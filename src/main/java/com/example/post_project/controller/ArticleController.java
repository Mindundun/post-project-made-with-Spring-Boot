package com.example.post_project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.dto.Criteria;
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

    // 게시글 전체 조회
    // @GetMapping("/articles")
    // public ResponseEntity<List<ArticleDto>> getArticles() {
    //     List<ArticleDto> articles = articleService.retrieveArticleList();

    //     // ResponseEntity는 HttpResponse
    //     // return ResponseEntity.ok().body(articles);              // builder pattern
    //     return new ResponseEntity<>(articles, HttpStatus.OK);   // 객체 생성
    // }

    // 게시글 등록
    // Map<String, Integer로 리턴타입을 갖는 이유 : json과 같이 {"key" : value}    
    @PostMapping("/articles")
    public ResponseEntity<Map<String, Integer>> postArticle(@RequestBody ArticleDto article) {
        int id = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("id",id)); // builder pattern
    }

    // 게시글 상세 조회
    // URL의 값은 String 타입이라 @PathVariable로 name이 "id"인 값을 int id에 넣어줌
    // GetMapping의 id와 PathVariable의 name의 id가 같아야함.
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable(name="id") int id) {
        ArticleDto article = articleService.retrieveArticle(id);
        return ResponseEntity.ok().body(article);
    }

    // 게시글 수정
    // status : (NO_CONTENT == 204) => 요청은 정상적으로 처리되었지만, 클라이언트에게 돌려줄 콘텐츠(응답 본문)가 없음
    @PutMapping("/articles/{id}")
    public ResponseEntity<String> putArticle(@PathVariable(name="id") int id, @RequestBody ArticleDto article) {
        // URL에 전달되는 id 값을 article 객체의 id 세팅
        article.setId(id);

        articleService.modifyArticle(article);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(""); // builder pattern
    }

    // 게시글 삭제
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable(name="id") int id) {
        articleService.removeArticle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    // 게시글 검색 => /articles?keyfield=writer&keyword=박민둔
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticle(
        @RequestParam(value = "keyfield", required = false, defaultValue = "") String keyfield,
        @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword ) 
    {   
        System.out.println("keyfield : " + keyfield + ", keyword : " + keyword);
        List<ArticleDto> articles = articleService.findArticleList(new Criteria(keyfield, keyword));
        return ResponseEntity.ok().body(articles);
    }

}
