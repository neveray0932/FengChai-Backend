package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "Stock對象", description = "")
public class Stock {

    @TableId(value = "st_id", type = IdType.AUTO)
    @ApiModelProperty(value = "庫存ID",required = true)
    private Integer stId;

    @ApiModelProperty(value = "庫存產品ID")
    private Integer stPid;

    @ApiModelProperty(value = "當前庫存量")
    private Integer stCurQty;

    @ApiModelProperty(value = "倉庫別ID")
    private Integer stDepid;


}
