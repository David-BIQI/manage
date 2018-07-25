package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "permission")
@Api(value="权限表")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Permission {


    @Id
    private Integer id;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "请求路径")
    private String url;

    @ApiModelProperty(value = "权限编码")
    private String permission;

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
