package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.dto.employee.EmployeeCreateDto;
import com.neveray0932.fengchai.common.dto.employee.EmployeeUpdateDto;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.entity.Employee;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface IEmployeeService extends IService<Employee> {

    ResultVO empCreate(EmployeeCreateDto employee);

    ResultVO empUpdate(EmployeeUpdateDto employeeUpdateDto);

    ResultVO empLeave(String empId);

    ResultVO empFindAll();

    ResultVO empFindOneById(String empId);

    void empUpdateUserNameFlag(String empId);

    ResultVO empNoUserName();

    ResultVO empPagination(Integer limit, Integer page, String empName, String empId, String empPosition);
}
