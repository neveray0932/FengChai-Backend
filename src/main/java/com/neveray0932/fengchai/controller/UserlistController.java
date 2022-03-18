package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Userlist;
import com.neveray0932.fengchai.service.impl.UserlistServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/user-list")
@CrossOrigin
@Api(value = "用戶管理",tags = "提供用戶業務相關的API")
public class UserlistController {

    @Autowired
    UserlistServiceImpl userlistService;

    @PostMapping("/register")
    @ApiOperation(value = "用戶註冊",notes = "用戶註冊")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    public ResultVO userRegister(@RequestBody Userlist userlist){
        ResultVO resultVO = userlistService.userRegister(userlist);
        return  resultVO;
    }

    @PostMapping("/login")
    @ApiOperation(value = "用戶登入",notes = "用戶登入")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    public ResultVO userLogin(@RequestBody Userlist userlist){
        ResultVO resultVO = userlistService.userLogin(userlist);
        return  resultVO;
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用戶登出",notes = "用戶登出")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    public ResultVO userLogin(){
        ResultVO resultVO = userlistService.userLogout();
        return  resultVO;
    }

}
