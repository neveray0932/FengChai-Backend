package com.neveray0932.fengchai.common.dto.userlist;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserListCreateDto implements DTOEntity {


    private String userName;

    private String userEmpid;
}
