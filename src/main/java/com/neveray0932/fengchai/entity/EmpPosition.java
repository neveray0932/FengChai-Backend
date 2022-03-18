package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.neveray0932.fengchai.common.vo.ApiMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Andy
 * @since 2022-03-15
 */
@Getter
@Setter
@TableName("emp_position")
@ApiModel(value = "EmpPosition對象", description = ApiMsg.API_DESCRIPTION)
public class EmpPosition {

    @TableId(value = "emp_position_id", type = IdType.AUTO)
    @ApiModelProperty(value = "職位編號",required = true)
    private Integer empPositionId;

    @ApiModelProperty(value = "職位名稱",required = true)
    private String empPositionName;


}
