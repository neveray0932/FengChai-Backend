package com.neveray0932.fengchai.common.dto.product;


import com.neveray0932.fengchai.common.vo.ApiMsg;
import com.neveray0932.fengchai.common.dto.DTOEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "ProductUpdate對象",
        description = ApiMsg.API_DESCRIPTION)
public class ProductUpdateDto implements DTOEntity {

    @ApiModelProperty(value = "產品ID",required = true)
    private String pId;

    @ApiModelProperty(value = "產品名稱")
    private String pName;

    @ApiModelProperty(value = "產品單位名稱")
    private String pUnitName;

    @ApiModelProperty(value = "產品價格")
    private Integer pPrice;

    @ApiModelProperty(value = "產品係數")
    private Float pCoefficient;

    @ApiModelProperty(value = "產品成本")
    private Integer pCost;

    @ApiModelProperty(value = "產品尺寸")
    private String pSize;

    @ApiModelProperty(value = "供應商名稱")
    private String compName;

    @ApiModelProperty(value = "產品備註")
    private String pRemark;

    @ApiModelProperty(value = "邏輯刪除")
    private Integer delFlag;
}
