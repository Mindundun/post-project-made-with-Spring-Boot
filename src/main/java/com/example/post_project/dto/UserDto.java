package com.example.post_project.dto;

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
public class UserDto {
    private int id;
    private String email;
    private String phone;
}
