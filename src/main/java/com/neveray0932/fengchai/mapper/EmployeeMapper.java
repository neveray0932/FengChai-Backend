package com.neveray0932.fengchai.mapper;

import com.neveray0932.fengchai.common.dto.employee.EmployeeNoCondition;
import com.neveray0932.fengchai.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> findAllWithNoCondition();

    List<EmployeeNoCondition> findAllWithNoConditionPage(Integer limit,Integer page, String empName, String empId, String empPosition );

    EmployeeNoCondition findByEmpIdGetPosition(String empId);

}
