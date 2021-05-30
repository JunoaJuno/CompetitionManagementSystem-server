package com.juno.competitionmanagementsystemserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "com-juno-competitionmanagementsystemserver-model-WorkInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.work_info")
public class WorkInfo implements Serializable {
    public static final String COL_ID = "id";
    public static final String COL_WORK_NAME = "work_name";
    public static final String COL_IS_REVIEW_PASS = "is_review_pass";
    public static final String COL_WORK_URL = "work_url";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_REVIEW_NOTES = "review_notes";
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 作品名称
     */
    @TableField(value = "work_name")
    @ApiModelProperty(value = "作品名称")
    private String workName;
    /**
     * 审核状态（1审核通过，2审核中，0审核不通过）
     */
    @TableField(value = "is_review_pass")
    @ApiModelProperty(value = "审核状态（1审核通过，2审核中，0审核不通过）")
    private Byte isReviewPass;
    /**
     * 作品上传URL
     */
    @TableField(value = "work_url")
    @ApiModelProperty(value = "作品上传URL")
    private String workUrl;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 审核备注
     */
    @TableField(value = "review_notes")
    @ApiModelProperty(value = "审核备注")
    private String reviewNotes;
}