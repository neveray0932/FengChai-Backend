package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Depository;
import com.neveray0932.fengchai.entity.ProductUnit;
import com.neveray0932.fengchai.service.impl.DepositoryServiceImpl;
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
@RequestMapping("/depository")
@Api(value = "倉庫別",tags = "提供倉庫別業務相關的API")
@CrossOrigin
public class DepositoryController {

    @Autowired
    DepositoryServiceImpl depositoryService;

    @ApiOperation(value = "倉庫別列表",notes = "取得所有倉庫別")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = depositoryService.depositoryFindAll();
        return resultVO;
    }

    @ApiOperation(value = "新增倉庫別",notes = "新增倉庫別")
    @PostMapping("/add")
    public ResultVO create(@RequestBody Depository depository){
        ResultVO resultVO = depositoryService.depositoryCreate(depository);
        return resultVO;
    }

    @ApiOperation(value = "修改倉庫別",notes = "根據倉庫別ID修改倉別名稱")
    @PutMapping("/update")
    public ResultVO update(@RequestBody Depository depository){
        ResultVO resultVO = depositoryService.depositoryUpdate(depository);
        return resultVO;
    }

    @ApiOperation(value = "刪除倉庫別",notes = "根據倉庫別編號刪除一個倉庫別名")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="depId", value = "倉庫別編號", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "depId")Integer depId){
        ResultVO resultVO = depositoryService.depositoryDelete(depId);
        return resultVO;
    }

}
