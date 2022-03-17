package com.neveray0932.fengchai.common.dto.userlist;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CADTECH
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListLoginDto implements DTOEntity {
    private String empUsername;
    private String empPassword;
}
