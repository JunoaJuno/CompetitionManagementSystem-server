package com.juno.competitionmanagementsystemserver.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juno.competitionmanagementsystemserver.config.WxConfig;
import com.juno.competitionmanagementsystemserver.dto.ArticleDto;
import com.juno.competitionmanagementsystemserver.dto.ArticleListDto;
import org.apache.http.Consts;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@Component
@EnableScheduling
@EnableAsync
public class WeChatArticleTask {

    private final WxConfig wxConfig;

    private final RedisTemplate<String, Serializable> serializableRedisTemplate;

    public WeChatArticleTask(WxConfig wxConfig, RedisTemplate<String, Serializable> serializableRedisTemplate) {
        this.wxConfig = wxConfig;
        this.serializableRedisTemplate = serializableRedisTemplate;
    }



    @Async
    @Scheduled(fixedDelay = 60000)
    public void getArticleTask() {
        String accessToken = "";
        Integer newsCount = 0;
        try {
            Content content = Request.Get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid" +
                    "="+wxConfig.getOfficialAccounts().getAppid()+"&secret="+wxConfig.getOfficialAccounts().getSecret())
                    .execute().returnContent();
            JSONObject resultJson = JSON.parseObject(content.asString(Consts.UTF_8));
            accessToken = resultJson.getString("access_token");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            Content content = Request.Get("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token" +
                    "="+ accessToken)
                    .execute().returnContent();
            JSONObject resultJson = JSON.parseObject(content.asString(Consts.UTF_8));
            newsCount = resultJson.getInteger("news_count");
        } catch (IOException e) {
            System.out.println(e);
        }
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (int i = 0; i < newsCount; i+=20) {
            try {
                Content content = Request.Post("https://api.weixin.qq.com/cgi-bin/material/batchget_material" +
                        "?access_token="+accessToken)
                        .addHeader("Content-Type", "application/json; charset=utf-8")
                        .bodyString("{\"type\": \"news\",\"count\": 20,\"offset\": "+i+"}",
                                ContentType.APPLICATION_JSON)
                        .execute().returnContent();
                JSONObject resultJson = JSON.parseObject(content.asString(Consts.UTF_8));
                JSONArray articleList = resultJson.getJSONArray("item");
                List<ArticleDto> list =JSONArray.parseArray(articleList.toJSONString(), ArticleDto.class);
                articleDtoList.addAll(list);
            }
            catch (IOException e) { System.out.println(e); }
        }
        articleDtoList.sort((o1, o2) -> o1.getUpdateTime() >= o2.getUpdateTime() ? 0 : 1);
        ArticleListDto articleListDto = new ArticleListDto(articleDtoList);
        serializableRedisTemplate.opsForValue().set("articles", articleListDto);
    }

}
