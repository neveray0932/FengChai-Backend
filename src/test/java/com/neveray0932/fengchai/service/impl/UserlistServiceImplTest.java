package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Userlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class UserlistServiceImplTest {

    @Autowired
    UserlistServiceImpl userlistService;

    @Test
    void userRegister() {
        Userlist userlist = new Userlist();
        userlist.setUserEmpid("E001");
        userlist.setUserName("test01");
        userlist.setUserPassword("password001");
        ResultVO resultVO = userlistService.userRegister(userlist);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    void userLogin() {
        Userlist userlist = new Userlist();
        userlist.setUserName("test01");
        userlist.setUserPassword("password001");
        ResultVO resultVO = userlistService.userLogin(userlist);
        System.out.println("resultVO = " + resultVO);
    }
}