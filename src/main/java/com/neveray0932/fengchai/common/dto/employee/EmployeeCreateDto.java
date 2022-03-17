package com.neveray0932.fengchai.common.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neveray0932.fengchai.common.Vo.ApiMsg;
import com.neveray0932.fengchai.common.dto.DTOEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@ApiModel(value = "EmployeeCreate對象",
        description = ApiMsg.API_DESCRIPTION)
public class EmployeeCreateDto implements DTOEntity {

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
    @ApiModelProperty(value = "到職時間")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "離職時間")
    private Date empLeaveTime;

    @ApiModelProperty(value = "職位")
    private String empPositionName;
}
