package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
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
@TableName("stock_input")
@ApiModel(value = "StockInput對象", description = "")
public class StockInput {

    @TableId(value = "sti_autono", type = IdType.AUTO)
    @ApiModelProperty(value = "庫存入庫ID",required = true)
    private Long stiAutono;

    @ApiModelProperty(value = "庫存入庫碼")
    private String stiCode;

    @ApiModelProperty(value = "庫存入庫日期")
    private LocalDate stiDate;

    @ApiModelProperty(value = "庫存入庫員工ID")
    private Integer stiEmpid;

    @ApiModelProperty(value = "庫存入庫倉別ID")
    private Integer stiDepoid;

    @ApiModelProperty(value = "庫存入庫產品ID")
    private Integer stiPid;




}
