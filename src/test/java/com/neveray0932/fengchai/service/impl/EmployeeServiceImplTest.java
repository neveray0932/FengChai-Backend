package com.neveray0932.fengchai.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    EmployeeServiceImpl employeeService;
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void method(){
//        Employee employee = new Employee();
//        employee.setEmpId("E010");
//        employee.setEmpName("獎新學");
//        employee.setEmpIdentityCard("A123457678");
//        employee.setEmpPhone("0912343475");
//        employee.setEmpAddress("台中市西屯區漢翔路520號");
////        EmployeeCreateDto employeeCreateDto = new EmployeeCreateDto();
////        employeeCreateDto.setEmpId("E012");
////        employeeCreateDto.setEmpName("獎新成");
////        employeeCreateDto.setEmpIdentityCard("A123457678");
////        employeeCreateDto.setEmpPhone("0912343475");
////        employeeCreateDto.setEmpAddress("台中市西屯區漢翔路520號");
//
//        ResultVO resultVO = employeeService.empCreate(employee);
//        System.out.println(resultVO);
    }

    @Test
    public void method2(){
//        Employee employee = new Employee();
//        employee.setEmpId("E010");
//        employee.setEmpAddress("台中市西屯區漢翔路77777號");
//        ResultVO resultVO = employeeService.empUpdate(employee);
//        System.out.println(resultVO);
    }

    @Test
    public void method3(){
        ResultVO resultVO = employeeService.empLeave("E006");
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    public void method4(){
        ResultVO resultVO = employeeService.empFindAll();
        System.out.println(resultVO);
    }

    @Test
    public void method5(){
        List<Employee> allWithNoCondition = employeeMapper.findAllWithNoCondition();
        System.out.println("allWithNoCondition = " + allWithNoCondition);
    }


    @Test
    void empNoUserName() {
        ResultVO resultVO = employeeService.empNoUserName();
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    void page(){
        Page<Employee> page = new Page<>(1,4);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("emp_id");
        IPage<Employee> employeePage = employeeService.getBaseMapper().selectPage(page, queryWrapper);
        Object o = JSON.toJSON(employeePage);
        System.out.println("o = " + o);
    }

//    @Test
//    void empPagination() {
//        ResultVO resultVO = employeeService.empPagination(1, 5);
//        System.out.println("resultVO = " + resultVO);
//    }
}