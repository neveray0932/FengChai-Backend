package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Supplier;
import com.neveray0932.fengchai.service.impl.SupplierServiceImpl;
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
@RequestMapping("/supplier")
@CrossOrigin
@Api(value = "供應商管理",tags = "提供供應商業務相關的API")
public class SupplierController {

    @Autowired
    SupplierServiceImpl supplierService;

    @ApiOperation(value = "供應商列表",notes = "取得所有供應商")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = supplierService.supplierFindAll();
        return resultVO;
    }

//    @ApiOperation(value = "單一廠商",notes = "根據廠商ID取得一個廠商")
//    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
//    @ApiImplicitParam(dataType = "integer", name="compId", value = "廠商ID", required = true)
//    @GetMapping("/single")
//    public ResultVO findOne(@RequestParam(value = "compId")Integer compId){
//        ResultVO resultVO = supplierService.empFindOneById(empId);
//        return resultVO;
//    }

    @ApiOperation(value = "新增供應商",notes = "新增供應商")
    @PostMapping("/add")
    public ResultVO create(@RequestBody Supplier supplier){
        ResultVO resultVO = supplierService.supplierCreate(supplier);
        return resultVO;
    }

    @ApiOperation(value = "修改供應商",notes = "根據廠商ID修改供應商")
    @PutMapping("/update")
    public ResultVO update(@RequestBody Supplier supplier){
        ResultVO resultVO = supplierService.supplierUpdate(supplier);
        return resultVO;
    }

    @ApiOperation(value = "刪除供應商",notes = "根據供應商編號刪除一個供應商")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="supplierId", value = "供應商ID", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "supplierId")Integer supplierId){
        ResultVO resultVO = supplierService.supplierDelete(supplierId);
        return resultVO;
    }

    @GetMapping("/page")
    @ApiOperation(value = "條件分頁查詢", notes = "輸入Page、Limit及條件")
    @ApiImplicitParams({
            @ApiImplicitParam(name="limit",value="筆數(頁)",required = true),
            @ApiImplicitParam(name="page",value="當前頁數",required = true),
            @ApiImplicitParam(name="supplierName",value="供應商名稱"),


    })
    public ResultVO page(@RequestParam(value = "limit") Integer limit,
                         @RequestParam(value = "page") Integer page,
                         @RequestParam(value = "supplierName") String supplierName){
        ResultVO resultVO = supplierService.supplierPagination(limit, page,supplierName);
        return resultVO;

    }

}
