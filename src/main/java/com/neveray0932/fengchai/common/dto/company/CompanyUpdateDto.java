package com.neveray0932.fengchai.common.dto.company;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyUpdateDto implements DTOEntity {
    private Integer compId;

    private String compName;

    private String compTaxNumber;

    private String compAddress;

    private String compCharge;

    private String compMail;

    private String compPhone;

    private String compContact;
}
