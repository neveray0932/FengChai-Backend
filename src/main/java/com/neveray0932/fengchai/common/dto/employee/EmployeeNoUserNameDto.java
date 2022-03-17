package com.neveray0932.fengchai.common.dto.employee;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeNoUserNameDto implements DTOEntity {
    private String empId;

    private String empName;

}
