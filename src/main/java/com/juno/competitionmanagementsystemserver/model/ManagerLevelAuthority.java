package com.juno.competitionmanagementsystemserver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="com-juno-competitionmanagementsystemserver-model-ManagerLevelAuthority")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "graduation.manager_level_authority")
public class ManagerLevelAuthority implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * manager_level表ID
     */
    @TableField(value = "manager_level_id")
    @ApiModelProperty(value="manager_level表ID")
    private Integer managerLevelId;

    /**
     * authority_info表ID
     */
    @TableField(value = "authority_id")
    @ApiModelProperty(value="authority_info表ID")
    private Integer authorityId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_MANAGER_LEVEL_ID = "manager_level_id";

    public static final String COL_AUTHORITY_ID = "authority_id";
}