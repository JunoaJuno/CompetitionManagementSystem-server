package com.juno.competitionmanagementsystemserver.dto;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "com-juno-competitionmanagementsystemserver-dto-AtricleDto")
public class ArticleDto implements Serializable {

    @JSONField(alternateNames = "media_id")
    private String mediaId;

    private Content content;

    @JSONField(alternateNames = "update_time")
    private Integer updateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Content {

        @JSONField(alternateNames = "news_item")
        private List<Article> newsItem;

        @JSONField(alternateNames = "create_time")
        private Integer createTime;

        @JSONField(alternateNames = "update_time")
        private Integer updateTime;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Article{
            private String title;

            private String author;

            private String digest;

            private String content;

            @JSONField(alternateNames = "content_source_url")
            private String contentSourceUrl;

            @JSONField(alternateNames = "thumb_media_id")
            private String thumbMediaId;

            @JSONField(alternateNames = "show_cover_pic")
            private Integer showCoverPic;

            private String url;

            @JSONField(alternateNames = "thumb_url")
            private String thumbUrl;

            @JSONField(alternateNames = "need_open_comment")
            private Integer needOpenComment;

            @JSONField(alternateNames = "only_fans_can_comment")
            private Integer onlyFansCanComment;
        }
    }

    private static final long serialVersionUID = 1L;
}
