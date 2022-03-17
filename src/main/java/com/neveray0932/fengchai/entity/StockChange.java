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
@TableName("stock_change")
@ApiModel(value = "StockChange對象", description = "")
public class StockChange {

    @TableId(value = "stc_autono", type = IdType.AUTO)
    @ApiModelProperty(value = "庫存異動ID",required = true)
    private Long stcAutono;

    @ApiModelProperty(value = "庫存異動日期")
    private LocalDate stcDate;

    @ApiModelProperty(value = "庫存異動碼")
    private String stcCode;

    @ApiModelProperty(value = "庫存異動入庫")
    private String stcInOut;

    @ApiModelProperty(value = "庫存異動產品ID")
    private Integer stcPid;

    @ApiModelProperty(value = "庫存異動數量")
    private Integer stcCount;

    @ApiModelProperty(value = "庫存異動ID")
    private Integer stcDepoid;

    @ApiModelProperty(value = "庫存異動客戶ID")
    private Integer stcCustid;


}
