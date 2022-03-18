package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.service.impl.EmpPositionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Andy
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/emp-position")
@Api(value = "員工職位",tags = "提供員工職位業務相關的API")
@CrossOrigin
public class EmpPositionController {

    @Autowired
    EmpPositionServiceImpl empPositionService;

    @GetMapping("/list")
    @ApiOperation(value = "職位列表",notes = "取得所有職位")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    public ResultVO list(){
        ResultVO resultVO = empPositionService.empPositionFindAll();
        return resultVO;
    }

}
