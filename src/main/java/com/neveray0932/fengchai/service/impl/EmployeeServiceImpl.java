package com.neveray0932.fengchai.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neveray0932.fengchai.common.dto.*;
import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.common.dto.employee.*;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.EmpPosition;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.mapper.EmployeeMapper;
import com.neveray0932.fengchai.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    EmpPositionServiceImpl empPositionService;


    @Override
    public ResultVO empPagination(Integer limit, Integer page, String empName, String empId, String empPosition) {

        Integer pages = (page-1)*limit;
        int count = 0;
        String trimEmpId = empId.trim();
        String trimEmpName = empName.trim();
        String trimEmpPosition = empPosition.trim();

        List<EmployeeNoCondition> noConditions = getBaseMapper().findAllWithNoConditionPage(limit,pages,trimEmpName,trimEmpId,trimEmpPosition);

        PageDto pageDto = new PageDto();
        if (trimEmpId.length()==0 && trimEmpName.length()==0 && trimEmpPosition.length()==0){

            count = count();
            pageDto.setTotal((long) count);
            pageDto.setRecords(noConditions);
        }else{

            pageDto.setTotal((long) noConditions.size());
            pageDto.setRecords(noConditions);
        }


        return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_QUERY,pageDto);
    }

    @Override
    public void empUpdateUserNameFlag(String empId) {
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpUsernameFlag(1);
        updateById(employee);
    }

    @Override
    public ResultVO empNoUserName() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Employee::getEmpUsernameFlag,0);
        List<Employee> list = list(queryWrapper);
        List<DTOEntity> dtoList = new DtoUtils().convertToDtoList(list, new EmployeeNoUserNameDto());
        if (!Objects.isNull(list)){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,dtoList);
        }
        return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);
    }

    @Override
    public ResultVO empFindOneById(String empId) {
        Employee employee = getById(empId);
        DTOEntity dtoEntity = new DtoUtils().convertToDto(employee, new EmployeeFindOneDto());
        if(!Objects.isNull(employee)){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,dtoEntity);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);


    }

    @Override
    public ResultVO empFindAll() {
        List<Employee> employeeList = getBaseMapper().findAllWithNoCondition();

        if (!employeeList.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,employeeList);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);


    }

    @Override
    public ResultVO empCreate(EmployeeCreateDto employeeCreateDto) {

        Employee id = getById(employeeCreateDto.getEmpId());
        if (!Objects.isNull(id)){
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.EXIT,null);
        }

        String empPositionName = employeeCreateDto.getEmpPositionName();

        QueryWrapper<EmpPosition> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(EmpPosition::getEmpPositionName,empPositionName);
        EmpPosition empPosition = empPositionService.getOne(queryWrapper);


        Employee employee = new Employee();

        employee.setEmpId(employeeCreateDto.getEmpId());
        employee.setEmpName(employeeCreateDto.getEmpName());
        employee.setEmpAddress(employeeCreateDto.getEmpAddress());
        employee.setEmpPhone(employeeCreateDto.getEmpPhone());
        employee.setEmpIdentityCard(employeeCreateDto.getEmpIdentityCard());
        employee.setEmpPositionId(empPosition.getEmpPositionId());
        employee.setCreateTime(employeeCreateDto.getCreateTime());

        boolean save = save(employee);

        if(save){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_INSERT,employeeCreateDto);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT,null);


    }

    @Override
    public ResultVO empUpdate(EmployeeUpdateDto employeeUpdateDto) {
        QueryWrapper<EmpPosition> queryWrapper = new QueryWrapper<>();

        queryWrapper.lambda().eq(EmpPosition::getEmpPositionName,employeeUpdateDto.getEmpPositionName());
        EmpPosition empPosition = empPositionService.getOne(queryWrapper);


        Employee employee = new Employee();

        employee.setEmpId(employeeUpdateDto.getEmpId());
        employee.setEmpName(employeeUpdateDto.getEmpName());
        employee.setEmpAddress(employeeUpdateDto.getEmpAddress());
        employee.setEmpPhone(employeeUpdateDto.getEmpPhone());
        employee.setEmpIdentityCard(employeeUpdateDto.getEmpIdentityCard());
        employee.setEmpPositionId(empPosition.getEmpPositionId());
        employee.setCreateTime(employeeUpdateDto.getCreateTime());

        boolean update = updateById(employee);

        if(update){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_UPDATED,employeeUpdateDto);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_UPDATED ,null);


    }

    @Override
    public ResultVO empLeave(String empId) {

        Employee employee = new Employee();

        employee.setEmpId(empId);
        employee.setLeaveFlag(1);
        employee.setEmpLeaveTime(new Date());

        boolean update = updateById(employee);

        if(update){
            Employee id = getById(empId);
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_DELETED,id);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_DELETED,false);


    }


}
