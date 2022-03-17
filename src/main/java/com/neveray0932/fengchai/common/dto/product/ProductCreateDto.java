package com.neveray0932.fengchai.common.dto.product;


import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCreateDto implements DTOEntity {


    private String pId;


    private String pName;


    private String pUnitName;


    private Integer pPrice;


    private Float pCoefficient;


    private Integer pCost;


    private String pSize;


    private String compName;


    private String pRemark;


    private Integer delFlag;
}
