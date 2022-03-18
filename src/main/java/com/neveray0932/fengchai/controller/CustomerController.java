package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Customer;
import com.neveray0932.fengchai.service.impl.CustomerServiceImpl;
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
@RequestMapping("/customer")
@CrossOrigin
@Api(value = "客戶管理",tags = "提供客戶業務相關的API")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @ApiOperation(value = "客戶列表",notes = "取得所有客戶")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = customerService.custFindAll();
        return resultVO;
    }

//    @ApiOperation(value = "單一客戶",notes = "根據客戶ID取得一個客戶")
//    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
//    @ApiImplicitParam(dataType = "integer", name="custId", value = "客戶ID", required = true)
//    @GetMapping("/single")
//    public ResultVO findOne(@RequestParam(value = "empId")String empId){
//        ResultVO resultVO = employeeService.empFindOneById(empId);
//        return resultVO;
//    }

    @ApiOperation(value = "新增客戶",notes = "新增客戶")
    @PostMapping("/add")
    public ResultVO create(@RequestBody Customer customer){
        ResultVO resultVO = customerService.custCreate(customer);
        return resultVO;
    }

    @ApiOperation(value = "修改客戶",notes = "根據客戶ID修改客戶")
    @PutMapping("/update")
    public ResultVO update(@RequestBody Customer customer){
        ResultVO resultVO = customerService.custUpdate(customer);
        return resultVO;
    }

    @ApiOperation(value = "刪除客戶",notes = "根據客戶ID刪除一個客戶")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="custId", value = "客戶ID", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "custId")Integer custId){
        ResultVO resultVO = customerService.custDelete(custId);
        return resultVO;
    }

    @GetMapping("/page")
    @ApiOperation(value = "條件分頁查詢", notes = "輸入Page、Limit及條件")
    @ApiImplicitParams({
            @ApiImplicitParam(name="limit",value="筆數(頁)",required = true),
            @ApiImplicitParam(name="page",value="當前頁數",required = true),
            @ApiImplicitParam(name="custName",value="客戶姓名"),


    })
    public ResultVO page(@RequestParam(value = "limit") Integer limit,
                         @RequestParam(value = "page") Integer page,
                         @RequestParam(value = "custName") String custName){
        ResultVO resultVO = customerService.custPagination(limit, page,custName);
        return resultVO;

    }


}
