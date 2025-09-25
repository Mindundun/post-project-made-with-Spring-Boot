package com.example.post_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.post_project.dto.ArticleDto;
import com.example.post_project.dto.ArticleFileDto;
import com.example.post_project.dto.Criteria;
import com.example.post_project.exception.ArticleNotFoundException;
import com.example.post_project.mapper.ArticleFileMapper;
import com.example.post_project.mapper.ArticleMapper;
import com.example.post_project.util.FileUploadUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 아래의 생성자 + @Autowired 코드와 같은 처리를 함
public class ArticleService {
    // field
    private final ArticleMapper articleMapper;
    private final FileUploadUtils fileUploadUtils;
    private final ArticleFileMapper articleFileMapper;

    // @Autowired
    // public ArticleService(ArticleMapper articleMapper) {
    //     this.articleMapper = articleMapper;
    // }

    // 게시글 목록 조회
    public List<ArticleDto> retrieveArticleList() {
        return articleMapper.selectArticleList();        
    }

    // 게시글 등록 : 텍스트만
    // 게시글 등록 후 id를 반환해야하기에 리턴타입을 int
    public int createArticle(ArticleDto article){
        articleMapper.insertArticle(article);
        return article.getId(); // Id를 반환
    }

    // 게시글 등록 : 텍스트와 파일
    public int createArticle(ArticleDto article, List<MultipartFile> files){
        articleMapper.insertArticle(article);
        int articleId = article.getId();

        List<ArticleFileDto> articleFiles = fileUploadUtils.uploadFiles(files);

        
        if (articleFiles != null){
            // articleId 세팅
            articleFiles.forEach(articleFile -> {
                articleFile.setArticleId(articleId);
            });
            
            articleFileMapper.insertArticleFile(articleFiles);
        }
        return articleId; // Id를 반환
    }

    // 게시글 상세 조회
    public ArticleDto retrieveArticle(int id) {
        // ArticleNotFoundException 던지기
        // RuntimeException은 throws하지 않고 바로 던질 수 있음
        if (articleMapper.selectArticleById(id) == null) {
            throw new ArticleNotFoundException("id : " + id + " is null");
        }
        return articleMapper.selectArticleById(id);
    }

    // 게시글 수정
    // 수정 시 리턴할 값이 필요 없으니 void
    public void modifyArticle(ArticleDto article){
        articleMapper.updateArticle(article);
    }

    // 게시글 삭제
    public void removeArticle(int id){
        if (articleMapper.selectArticleById(id) == null){
            throw new ArticleNotFoundException("id : " + id + " is null");
        }        
        articleMapper.deleteArticle(id);        
    }

    // 게시글 검색
    public List<ArticleDto> findArticleList(Criteria criteria){
        return articleMapper.findArticleList(criteria);
    }
}
