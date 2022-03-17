package com.neveray0932.fengchai.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.neveray0932.fengchai.common.Vo.ApiMsg;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Getter
@Setter
@Data
@ApiModel(value = "Employee對象",
        description = ApiMsg.API_DESCRIPTION)
public class Employee {

    @TableId(value = "emp_id",type = IdType.NONE)
    @ApiModelProperty(value = "員工編號",required = true)
    private String empId;

    @ApiModelProperty(value = "員工姓名",required = true)
    private String empName;

    @ApiModelProperty(value = "員工身分證")
    private String empIdentityCard;

    @ApiModelProperty(value = "員工電話")
    private String empPhone;

    @ApiModelProperty(value = "員工地址")
    private String empAddress;

    @ApiModelProperty(value = "員工有無帳號",notes = "預設0")
    private Integer empUsernameFlag;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "創建時間",hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "離職時間")
    private Date empLeaveTime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "編輯時間",hidden = true)
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "離職",hidden = true)
    private Integer leaveFlag;

    @ApiModelProperty(value = "職位ID")
    private Integer empPositionId;


}
