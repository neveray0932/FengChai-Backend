package com.neveray0932.fengchai.common.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EmployeeCreateDto implements DTOEntity {
    private String empId;

    private String empName;

    private String empIdentityCard;

    private String empPhone;

    private String empAddress;

    private Integer empUsernameFlag;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date empLeaveTime;


    private String empPositionName;
}
