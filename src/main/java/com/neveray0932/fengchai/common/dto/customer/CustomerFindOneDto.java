package com.neveray0932.fengchai.common.dto.customer;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerFindOneDto implements DTOEntity {

    private Integer custId;

    private String custName;

    private String custTaxNumber;

    private String custAddress;

    private String custCharge;

    private String custMail;

    private String custPhone;

    private String custContact;

    private Integer delFlag;
}
