package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.dto.role.FindUserRoleDto;
import com.neveray0932.fengchai.common.dto.userlist.LoginUserDto;
import com.neveray0932.fengchai.entity.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserlistServiceImpl userlistService;
    @Autowired
    RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userlist result = userlistService.getById(username);

        if(Objects.isNull(result)){
            System.out.println("查無此人");
            throw new RuntimeException("帳號或密碼輸入錯誤");
        }

        List<String> userRoles = roleService.getBaseMapper().getUserRoles(username);


        return new LoginUserDto(result,userRoles,null);
    }
}
