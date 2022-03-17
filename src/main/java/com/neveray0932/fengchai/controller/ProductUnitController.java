package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Employee;
import com.neveray0932.fengchai.entity.ProductUnit;
import com.neveray0932.fengchai.service.impl.ProductUnitServiceImpl;
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
@RequestMapping("/product-unit")
@Api(value = "產品單位",tags = "提供產品單位業務相關的API")
@CrossOrigin
public class ProductUnitController {

    @Autowired
    ProductUnitServiceImpl productUnitService;

    @ApiOperation(value = "單位列表",notes = "取得所有單位")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = productUnitService.prodUnitFindAll();
        return resultVO;
    }

    @ApiOperation(value = "新增產品單位",notes = "新增產品單位")
    @PostMapping("/add")
    public ResultVO create(@RequestBody ProductUnit productUnit){
        ResultVO resultVO = productUnitService.prodUnitCreate(productUnit);
        return resultVO;
    }

    @ApiOperation(value = "修改產品單位",notes = "根據產品單位編號修改單位")
    @PutMapping("/update")
    public ResultVO update(@RequestBody ProductUnit productUnit){
        ResultVO resultVO = productUnitService.prodUnitUpdate(productUnit);
        return resultVO;
    }

    @ApiOperation(value = "刪除產品單位",notes = "根據單位編號刪除一個單位")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="punitId", value = "產品單位編號", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "punitId")Integer punitId){
        ResultVO resultVO = productUnitService.prodUnitDelete(punitId);
        return resultVO;
    }


}
