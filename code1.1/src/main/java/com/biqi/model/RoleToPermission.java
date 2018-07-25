package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "role_to_permission")
@Api(value="角色与权限表")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleToPermission {

    @Id
    private Integer id;

    @ApiModelProperty(value = "权限id")
    private Integer permissionId;

    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    @ApiModelProperty(value = "1代表正常")
    private Integer status;

    @ApiModelProperty(value = "创建时间，系统填值")
    private Date created;

    @ApiModelProperty(value = "创建人，系统填值")
    private Integer createby;

    @ApiModelProperty(value = "更新时间，系统填值")
    private Date updated;

    @ApiModelProperty(value = "更新人，系统填值")
    private Integer updateby;

    @ApiModelProperty(value = "注释")
    private String remark;

}
