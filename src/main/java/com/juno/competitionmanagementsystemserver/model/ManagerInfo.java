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

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-ManagerInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.manager_info")
public class ManagerInfo implements Serializable {
    /**
     * 管理信息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="管理信息id")
    private Integer id;

    /**
     * 管理级别名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="管理级别名")
    private Integer name;

    /**
     * 所属部门
     */
    @TableField(value = "department_id")
    @ApiModelProperty(value="所属部门")
    private Integer departmentId;

    /**
     * 管理员信息创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="管理员信息创建时间")
    private Date createTime;

    /**
     * 管理员信息更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="管理员信息更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_DEPARTMENT_ID = "department_id";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}