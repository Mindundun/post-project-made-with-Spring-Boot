package com.example.post_project.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*; // 해당 assertj로 테스트

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.exception.ArticleNotFoundException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    void testRetrieveArticle() {
        // Given
        int id = 23;

        // When
        ArticleDto article = articleService.retrieveArticle(id);

        if (article.getUser() != null){
            System.out.println("article의 User Data : " + article.getUser());
        }
        
        if (!article.getFiles().isEmpty()) {
            article.getFiles().forEach(articleFile -> System.out.println("article의 articleFile Data : " + articleFile));
        }

        // Then
        assertThat(article).isNotNull();
    }

    @Test
    void testRetrieveArticle1() {
        // Given
        int id = 23;

        // When, Then
        assertThatThrownBy(() -> { // 에러 발생 시 성공. 에러 미 발생 시 실패.
            articleService.retrieveArticle(id);
            // throw new ArticleNotFoundException();
        }).isInstanceOf(ArticleNotFoundException.class) // 여기까지만 쓰면 타입만 비교
          .hasMessage("id : 23 is null");// 여기까지 쓰면 메세지도 비교  
    }
   
}
