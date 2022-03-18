package com.neveray0932.fengchai.common.dto.role;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindUserRoleDto implements DTOEntity {

    private String roleName;
}
