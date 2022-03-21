package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.neveray0932.fengchai.common.vo.ApiMsg;
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
@ApiModel(value = "Product對象", description = ApiMsg.API_DESCRIPTION)
public class Product {

    @TableId(value = "p_id", type = IdType.NONE)
    @ApiModelProperty(value = "產品ID",required = true)
    private String pId;

    @ApiModelProperty(value = "產品名稱")
    private String pName;

    @ApiModelProperty(value = "產品單位ID")
    private Integer pUnitId;

    @ApiModelProperty(value = "產品價格")
    private Integer pPrice;

    @ApiModelProperty(value = "產品係數")
    private Float pCoefficient;

    @ApiModelProperty(value = "產品成本")
    private Integer pCost;

    @ApiModelProperty(value = "產品尺寸")
    private String pSize;

    @ApiModelProperty(value = "供應商ID")
    private Integer pSupplierId;

    @ApiModelProperty(value = "產品備註")
    private String pRemark;

    @ApiModelProperty(value = "邏輯刪除")
    private Integer delFlag;



}
