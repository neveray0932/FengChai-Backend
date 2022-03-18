package com.neveray0932.fengchai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neveray0932.fengchai.common.dto.DTOEntity;
import com.neveray0932.fengchai.common.dto.role.FindUserRoleDto;
import com.neveray0932.fengchai.common.dto.userlist.LoginUserDto;
import com.neveray0932.fengchai.common.dto.userlist.UserListCreateDto;
import com.neveray0932.fengchai.common.vo.ResultMsg;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.entity.UserTemp;
import com.neveray0932.fengchai.entity.Userlist;
import com.neveray0932.fengchai.mapper.UserlistMapper;
import com.neveray0932.fengchai.service.IUserlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class UserlistServiceImpl extends ServiceImpl<UserlistMapper, Userlist> implements IUserlistService {

    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserTempServiceImpl userTempService;

    @Override
    public ResultVO userRegister(Userlist userlist) {
        synchronized (this) {
            Userlist userlist1 = new Userlist();

            String userName = userlist.getUserName();
            String userPassword = userlist.getUserPassword();
            //註冊前必須先取得empID，否則註冊失敗
            String userEmpid = userlist.getUserEmpid();

            Employee employee = employeeService.getById(userEmpid);
            Integer empUsernameFlag = employee.getEmpUsernameFlag();


            Userlist id = getById(userName);

            if(!userName.isEmpty() && !userPassword.isEmpty()){
                userlist1.setUserName(userName);
                //加密
                userlist1.setUserPassword(passwordEncoder.encode(userPassword));
                userlist1.setUserEmpid(userEmpid);
            }


            if (!Objects.isNull(userlist1) && Objects.isNull(id) && empUsernameFlag.equals(0)) {

                boolean save = save(userlist1);
                DTOEntity dtoEntity = new DtoUtils().convertToDto(userlist1, new UserListCreateDto());
                if (save) {
                    employeeService.empUpdateUserNameFlag(userEmpid);
                    return new ResultVO(HttpStatus.CREATED.value(), ResultMsg.SUCCESS_REGISTER, dtoEntity);
                }
                else{
                    return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_REGISTER, null);
                }
            }
        }
        return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_REGISTER, null);
    }

    @Override
    public ResultVO userLogin(Userlist userlist) {
        HashMap<String,Object> map = new HashMap<>();

        try {
            String userName = userlist.getUserName();
            String userPassword = userlist.getUserPassword();

            //AuthenticationManager authenticate進行用戶認證
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userName,userPassword);
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);



            //如果沒通過，給出對應提示
            if(Objects.isNull(authenticate)){
                throw new RuntimeException("登入失敗");
            }

            //如果認證通過了，生成jwt
            LoginUserDto loginUser =(LoginUserDto) authenticate.getPrincipal();

            if (loginUser.getUserlist().getUserEmpid().isEmpty()){
                return new ResultVO(HttpStatus.NO_CONTENT.value(), "帳號尚未啟動，請聯絡管理員",null);
            }
            List<String> permissions = loginUser.getPermissions();
            String empId = loginUser.getUserlist().getUserEmpid();
            map.put("empId",empId);
            map.put("role",permissions);
            String tokenStr = Jwts.builder()
                    .setClaims(map)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                    .signWith(SignatureAlgorithm.HS256, "fengchai6666")
                    .compact();

            //把完整的用戶信息存入redis userid作為Key

            try{
                UserTemp userTemp = new UserTemp();
                userTemp.setEmpId(loginUser.getUserlist().getUserEmpid());
                userTemp.setUserName(loginUser.getUserlist().getUserName());
                userTemp.setLoginDate(new Date());
                userTempService.save(userTemp);


            }catch (Exception e){
                System.out.println("user暫存表存入失敗");
                return new ResultVO(HttpStatus.NO_CONTENT.value(), "帳號已登入");
//            throw new RuntimeException("user暫存表存入失敗");
            }


            HashMap<String,String> token = new HashMap<>();
            token.put("token",tokenStr);
            return new ResultVO(HttpStatus.OK.value(), "登入成功",token);


        }catch (Exception e){
            System.out.println(e);
        }



        return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_LOGIN,null);
    }

    @Override
    public ResultVO userLogout() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserTemp userTemp = (UserTemp) authenticationToken.getPrincipal();

        String empId = userTemp.getEmpId();

        QueryWrapper<UserTemp> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserTemp::getEmpId,empId);

        boolean remove = userTempService.remove(queryWrapper);

        if(!remove){
            throw new RuntimeException("user暫存表刪除失敗");
        }

        return new ResultVO(HttpStatus.OK.value(),"成功登出",null);
    }
}
