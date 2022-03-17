package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.dto.employee.EmployeeCreateDto;
import com.neveray0932.fengchai.common.dto.employee.EmployeeUpdateDto;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.*;
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
@RequestMapping("/employee")
@CrossOrigin
@Api(value = "員工管理",tags = "提供員工業務相關的API")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @ApiOperation(value = "員工列表",notes = "取得所有員工")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = employeeService.empFindAll();
        return resultVO;
    }

    @ApiOperation(value = "單一員工",notes = "根據員工編號取得一個員工")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam(dataType = "string", name="empId", value = "員工編號", required = true)
    @GetMapping("/single")
    public ResultVO findOne(@RequestParam(value = "empId")String empId){
        ResultVO resultVO = employeeService.empFindOneById(empId);
        return resultVO;
    }



    @ApiOperation(value = "新增員工",notes = "新增員工")
    @PostMapping("/add")
    public ResultVO create(@RequestBody EmployeeCreateDto employee){
        ResultVO resultVO = employeeService.empCreate(employee);
        return resultVO;
    }

    @ApiOperation(value = "修改員工",notes = "根據員工編號修改員工")
    @PutMapping("/update")
    public ResultVO update(@RequestBody EmployeeUpdateDto employeeUpdateDto){
        ResultVO resultVO = employeeService.empUpdate(employeeUpdateDto);
        return resultVO;
    }

    @ApiOperation(value = "刪除員工",notes = "根據員工編號刪除一個員工")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam(dataType = "string", name="empId", value = "員工編號", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "empId")String empId){
        ResultVO resultVO = employeeService.empLeave(empId);
        return resultVO;
    }

    @GetMapping("/page")
    @ApiOperation(value = "分頁查詢", notes = "輸入Page及Limit")
    @ApiImplicitParams({
            @ApiImplicitParam(name="limit",value="筆數(頁)",required = true),
            @ApiImplicitParam(name="page",value="當前頁數",required = true),
            @ApiImplicitParam(name="empName",value="員工姓名"),
            @ApiImplicitParam(name="empId",value="員工ID"),
            @ApiImplicitParam(name="empPosition",value="員工職位")

    })
    public ResultVO page(@RequestParam(value = "limit") Integer limit,
                         @RequestParam(value = "page") Integer page,
                         @RequestParam(value = "empName") String empName,
                         @RequestParam(value = "empId") String empId,
                         @RequestParam(value = "empPosition") String empPosition){
        ResultVO resultVO = employeeService.empPagination(limit, page,empName,empId,empPosition);
        return resultVO;

    }

    @ApiOperation(value = "無帳號員工列表",notes = "取得所有無帳號員工")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/no-username-list")
    public ResultVO noUserNameList(){
        ResultVO resultVO = employeeService.empNoUserName();
        return resultVO;
    }

}
