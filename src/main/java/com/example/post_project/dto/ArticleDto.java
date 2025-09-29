package com.example.post_project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString // tostring메소드를 자동적으로 만들어줌. 추후 ArticleServiceTest에서 사용
public class ArticleDto {
    // field, property
    private int id;

    @NotBlank(message="Title cannot be empty")
    @Size(max = 50, message = "Title cannot exceed 50 characters")
    private String title;

    @NotBlank(message="Writer cannot be empty")
    private String writer;

    @NotBlank(message="Cotnents cannot be empty")
    private String contents;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")      // 날짜 및 시간 형식 지정 (출력용)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 주로 폼 데이터나 쿼리 파라미터를 자바 객체로 바인딩할 때 날짜/시간 포맷을 지정합니다.
    private LocalDateTime regDate;

    // 1 : N 관계 
    List<ArticleFileDto> files = new ArrayList<>();

    // user와 1:1 관계
    private UserDto user;

}
