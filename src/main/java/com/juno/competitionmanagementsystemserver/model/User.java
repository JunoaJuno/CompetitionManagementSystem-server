package com.juno.competitionmanagementsystemserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.`user`")
public class User implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 昵称
     */
    @TableField(value = "nickName")
    @ApiModelProperty(value="昵称")
    private String nickname;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "updated_time")
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;

    /**
     * openid
     */
    @TableField(value = "open_id")
    @ApiModelProperty(value="openid")
    private String openId;

    /**
     * 验证时间
     */
    @TableField(value = "verification_time")
    @ApiModelProperty(value="验证时间")
    private Date verificationTime;

    /**
     * session key
     */
    @TableField(value = "session_key")
    @ApiModelProperty(value="session key")
    private String sessionKey;

    /**
     * 电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="电话")
    private String phone;

    /**
     * 头像url
     */
    @TableField(value = "avatarUrl")
    @ApiModelProperty(value="头像url")
    private String avatarurl;

    /**
     * 性别
     */
    @TableField(value = "gender")
    @ApiModelProperty(value="性别")
    private Integer gender;

    /**
     * 语言
     */
    @TableField(value = "`language`")
    @ApiModelProperty(value="语言")
    private String language;

    /**
     * 城市
     */
    @TableField(value = "city")
    @ApiModelProperty(value="城市")
    private String city;

    /**
     * 国家
     */
    @TableField(value = "country")
    @ApiModelProperty(value="国家")
    private String country;

    /**
     * 省份
     */
    @TableField(value = "province")
    @ApiModelProperty(value="省份")
    private String province;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 学号
     */
    @TableField(value = "stu_id")
    @ApiModelProperty(value="学号")
    private Integer stuId;

    /**
     * 工号
     */
    @TableField(value = "tea_id")
    @ApiModelProperty(value="工号")
    private Integer teaId;

    /**
     * 身份
     */
    @TableField(value = "`Identity`")
    @ApiModelProperty(value="身份")
    private String identity;

    /**
     * 权限id
     */
    @TableField(value = "manage_id")
    @ApiModelProperty(value="权限id")
    private Integer manageId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NICKNAME = "nickName";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATED_TIME = "updated_time";

    public static final String COL_OPEN_ID = "open_id";

    public static final String COL_VERIFICATION_TIME = "verification_time";

    public static final String COL_SESSION_KEY = "session_key";

    public static final String COL_PHONE = "phone";

    public static final String COL_AVATARURL = "avatarUrl";

    public static final String COL_GENDER = "gender";

    public static final String COL_LANGUAGE = "language";

    public static final String COL_CITY = "city";

    public static final String COL_COUNTRY = "country";

    public static final String COL_PROVINCE = "province";

    public static final String COL_PASSWORD = "password";

    public static final String COL_STU_ID = "stu_id";

    public static final String COL_TEA_ID = "tea_id";

    public static final String COL_IDENTITY = "Identity";

    public static final String COL_MANAGE_ID = "manage_id";
}