package com.example.post_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
    
    private String keyfield;    // 검색조건 : writer, contents, title
    private String keyword;     // 검색어

}
