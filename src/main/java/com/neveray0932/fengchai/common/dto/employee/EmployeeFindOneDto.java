package com.neveray0932.fengchai.common.dto.employee;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeFindOneDto implements DTOEntity {

    private String empId;

    private String empName;

    private String empIdentityCard;

    private String empPhone;

    private String empAddress;

    private Integer empUsernameFlag;

    private Integer leaveFlag;

}
