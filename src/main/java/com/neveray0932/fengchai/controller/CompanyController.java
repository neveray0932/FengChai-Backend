package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Company;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.service.impl.CompanyServiceImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@RestController
@RequestMapping("/company")
@CrossOrigin
@Api(value = "廠商管理",tags = "提供廠商業務相關的API")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @ApiOperation(value = "廠商列表",notes = "取得所有廠商")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = companyService.compFindAll();
        return resultVO;
    }

//    @ApiOperation(value = "單一廠商",notes = "根據廠商ID取得一個廠商")
//    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
//    @ApiImplicitParam(dataType = "integer", name="compId", value = "廠商ID", required = true)
//    @GetMapping("/single")
//    public ResultVO findOne(@RequestParam(value = "compId")Integer compId){
//        ResultVO resultVO = companyService.empFindOneById(empId);
//        return resultVO;
//    }

    @ApiOperation(value = "新增廠商",notes = "新增廠商")
    @PostMapping("/add")
    public ResultVO create(@RequestBody Company company){
        ResultVO resultVO = companyService.compCreate(company);
        return resultVO;
    }

    @ApiOperation(value = "修改廠商",notes = "根據廠商ID修改廠商")
    @PutMapping("/update")
    public ResultVO update(@RequestBody Company company){
        ResultVO resultVO = companyService.compUpdate(company);
        return resultVO;
    }

    @ApiOperation(value = "刪除廠商",notes = "根據廠商編號刪除一個廠商")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="compId", value = "廠商ID", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "compId")Integer compId){
        ResultVO resultVO = companyService.compDelete(compId);
        return resultVO;
    }

}
