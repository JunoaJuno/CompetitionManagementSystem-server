package com.juno.competitionmanagementsystemserver.controller;


import com.juno.competitionmanagementsystemserver.dto.ArticleDto;
import com.juno.competitionmanagementsystemserver.dto.ArticleListDto;
import com.juno.competitionmanagementsystemserver.dto.ArticlesDto;
import com.juno.competitionmanagementsystemserver.dto.ResponseStruct;
import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "文章管理")
@Controller
@CrossOrigin
@RequestMapping(value = {"/api/v1/department/"})
public class ArticlesController {

    private final RedisTemplate<String, Serializable> serializableRedisTemplate;

    public ArticlesController(RedisTemplate<String, Serializable> serializableRedisTemplate) {
        this.serializableRedisTemplate = serializableRedisTemplate;
    }

    @GetMapping(value = "/list")
    @ResponseBody
    @Valid
    public ResponseEntity<ResponseStruct<List<ArticlesDto>>> getArticles(@Digits(integer = 5, fraction = 0)
                                                                         @Positive
                                                                         @RequestParam
                                                                                 Integer current,
                                                                         @Digits(integer = 5, fraction = 0)
                                                                         @Positive
                                                                         @RequestParam
                                                                                 Integer size) {
        ArticleListDto articleListDto = (ArticleListDto) serializableRedisTemplate.opsForValue().get("articles");
        List<ArticlesDto> articlesDtos = new ArrayList<>();
        Assert.notNull(articleListDto, "无文章");
        Assert.isTrue(current <= articleListDto.getArticleDtoList().size(),"没有文章了");
        for (int i = current; i < articleListDto.getArticleDtoList().size() && i < size; i++) {
            ArticlesDto articlesDto = new ArticlesDto();
            articlesDto.setAuthor(articleListDto.getArticleDtoList().get(i).getContent().getNewsItem().get(0).getAuthor());
            articlesDto.setDigest(articleListDto.getArticleDtoList().get(i).getContent().getNewsItem().get(0).getDigest());
            articlesDto.setThumbUrl(articleListDto.getArticleDtoList().get(i).getContent().getNewsItem().get(0).getThumbUrl());
            articlesDto.setTitle(articleListDto.getArticleDtoList().get(i).getContent().getNewsItem().get(0).getTitle());
            articlesDto.setUrl(articleListDto.getArticleDtoList().get(i).getContent().getNewsItem().get(0).getUrl());
            articlesDtos.add(articlesDto);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseStruct<>("ok", articlesDtos));
    }
}
