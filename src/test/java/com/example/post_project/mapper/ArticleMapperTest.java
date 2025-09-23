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
        assertThat(articles).hasSize(9);
        assertThat(articles.size()).isEqualTo(9);

    }
}
