package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.dto.DTOEntity;
import com.neveray0932.fengchai.common.dto.userlist.UserListCreateDto;
import com.neveray0932.fengchai.common.dto.userlist.UserListFindOneDto;
import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.entity.Userlist;
import com.neveray0932.fengchai.mapper.UserlistMapper;
import com.neveray0932.fengchai.service.IUserlistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    @Override
    public ResultVO userRegister(Userlist userlist) {
        synchronized (this) {
            Userlist userlist1 = new Userlist();

            String userName = userlist.getUserName();
            String userPassword = userlist.getUserPassword();
            String userEmpid = userlist.getUserEmpid();

            Employee employee = employeeService.getById(userEmpid);
            Integer empUsernameFlag = employee.getEmpUsernameFlag();


            Userlist id = getById(userName);

            if(!userName.isEmpty() && !userPassword.isEmpty()){
                userlist1.setUserName(userName);
                //加密
                userlist1.setUserPassword(userPassword);
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

        try {
            String userName = userlist.getUserName();
            String userPassword = userlist.getUserPassword();


            if(!Objects.isNull(userlist)){
                if(!userName.isEmpty() && !userPassword.isEmpty()){

                    Userlist id = getById(userName);

                    if (id.getUserEmpid().isEmpty()){
                        return new ResultVO(HttpStatus.NO_CONTENT.value(), "帳號尚未啟動，請聯絡管理員",null);
                    }
                    if (!Objects.isNull(id)){
                        DTOEntity dtoEntity = new DtoUtils().convertToDto(id, new UserListFindOneDto());
                        return id.getUserPassword().equals(userPassword) ?
                                new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_LOGIN,dtoEntity) : new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_LOGIN,null);
                    }
                }

            }
        }catch (Exception e){
            System.out.println(e);
        }



        return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_LOGIN,null);
    }
}
