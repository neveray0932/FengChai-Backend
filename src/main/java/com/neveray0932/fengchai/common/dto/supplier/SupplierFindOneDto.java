package com.neveray0932.fengchai.common.dto.supplier;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierFindOneDto implements DTOEntity {

    private Integer supplierId;


    private String supplierName;


    private String supplierTaxNumber;


    private String supplierAddress;


    private String supplierCharge;


    private String supplierMail;


    private String supplierPhone;


    private String supplierContact;
}
