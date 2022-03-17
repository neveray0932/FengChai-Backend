package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

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
@TableName("stock_output")
@ApiModel(value = "StockOutput對象", description = "")
public class StockOutput {

    @ApiModelProperty(value = "庫存出庫碼")
    private String stoCode;

    @ApiModelProperty(value = "庫存出庫ID", required = true)
    @TableId(value = "sto_autono", type = IdType.AUTO)
    private Long stoAutono;

    @ApiModelProperty(value = "庫存出庫日期")
    private Date stoDate;

    @ApiModelProperty(value = "庫存出庫員工ID")
    private Integer stoEmpid;

    @ApiModelProperty(value = "庫存出庫倉別ID")
    private Integer stoDepoid;

    @ApiModelProperty(value = "庫存出庫產品ID")
    private Integer stoPid;

    @ApiModelProperty(value = "庫存出庫ID")
    private Integer stoCustid;


}
