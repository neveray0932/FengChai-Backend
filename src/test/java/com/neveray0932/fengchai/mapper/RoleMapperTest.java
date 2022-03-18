package com.neveray0932.fengchai.mapper;

import com.neveray0932.fengchai.common.dto.role.FindUserRoleDto;
import com.neveray0932.fengchai.service.impl.RoleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMapperTest {

    @Autowired
    RoleServiceImpl roleService;

    @Test
    void getUserRoles() {
        List<String> test01 = roleService.getBaseMapper().getUserRoles("test01");
        System.out.println(test01);
    }
}