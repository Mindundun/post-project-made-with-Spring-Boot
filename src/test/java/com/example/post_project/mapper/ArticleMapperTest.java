package com.example.post_project.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.example.post_project.dto.ArticleDto;

import static org.assertj.core.api.Assertions.*;

// MyBatis 테스트가 기본적으로 임베디드 데이터베이스(H2Databae)를 사용하려는 동작을 방지한다. (중요)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
public class ArticleMapperTest {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void testSelectArticleList() {
        // Given

        // When
        List<ArticleDto> articles = articleMapper.selectArticleList();
        // Then
        assertThat(articles).hasSize(7);
        assertThat(articles.size()).isEqualTo(7);
    }
    
    @Test
    void testInsertArticle(){
        // Given
        ArticleDto articleDto = ArticleDto.builder()
            .title("박작가님의 신작 출간!")
            .writer("박작가님")
            .contents("박작가님의 새로운 서적이 출간됩니다. 많은 축하 부탁드립니다.")
            .build();

        // When
        articleMapper.insertArticle(articleDto);

        // Then
        assertThat(articleDto.getId()).isEqualTo(12);
        System.out.println(articleDto.getId());
    }

    @Test
    void testSelectArticleById(){
        // Given
        
        // when
        ArticleDto article = articleMapper.selectArticleById(13);
        // Then
        assertThat(article).isNotNull();
        System.out.println("article.getId() : " + article.getId());
        System.out.println(article.getContents());

        // void testSelectArticleById(){
        // // Given
        // ArticleDto articleDto = ArticleDto.builder()
        //     .title("박작가님의 신작 출간!")
        //     .writer("박작가님")
        //     .contents("박작가님의 새로운 서적이 출간됩니다. 많은 축하 부탁드립니다.")
        //     .build();

        // articleMapper.insertArticle(articleDto);

        // // when
        // ArticleDto article = articleMapper.selectArticleById(articleDto.getId());
        // // Then
        
        // System.out.println("article.getId() : " + article.getId());
        // assertThat(articleDto).isNotNull();
        // System.out.println("article.getId() : " + article.getId());
        // System.out.println(article.getContents());
    }

    @Test
    void testUpdateArticle(){
        // Given
        // insert
        ArticleDto articleDto = ArticleDto.builder()
            .title("Test박작가님의 신작 출간!")
            .writer("Test박작가님")
            .contents("Test박작가님의 새로운 서적이 출간됩니다. 많은 축하 부탁드립니다.")
            .build();

        articleMapper.insertArticle(articleDto);

        System.out.println("등록 : " + articleDto.getContents());

        ArticleDto articleDto1 = ArticleDto.builder()
                .title("개미는 둔둔")
                .contents("오늘도 둔둔")
                .writer("박개미민둔둔")
                .build();

        // When
        articleMapper.updateArticle(articleDto1);
        // Then
        assertThat(articleDto1.getTitle()).isEqualTo("개미는 둔둔");
    }

    @Test
    void testRemoveArticle(){
        // Given
        // insert
        ArticleDto articleDto = ArticleDto.builder()
            .title("Test박작가님의 신작 출간!")
            .writer("Test박작가님")
            .contents("Test박작가님의 새로운 서적이 출간됩니다. 많은 축하 부탁드립니다.")
            .build();

        articleMapper.insertArticle(articleDto);      

        // When
        int id = articleDto.getId();

        articleMapper.deleteArticle(id);
        ArticleDto foundArticle = articleMapper.selectArticleById(id);
        // Then
        assertThat(foundArticle).isNull();
        

    }
}
