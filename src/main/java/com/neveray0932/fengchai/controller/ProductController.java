package com.neveray0932.fengchai.controller;

import com.neveray0932.fengchai.common.dto.product.ProductCreateDto;
import com.neveray0932.fengchai.common.dto.product.ProductUpdateDto;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.service.impl.ProductServiceImpl;
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
@RequestMapping("/product")
@Api(value = "產品管理",tags = "提供產品業務相關的API")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @ApiOperation(value = "產品列表",notes = "取得所有產品")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO = productService.prodFindAll();
        return resultVO;
    }

    @ApiOperation(value = "新增產品",notes = "新增產品")
    @PostMapping("/add")
    public ResultVO create(@RequestBody ProductCreateDto productCreateDto){
        ResultVO resultVO = productService.prodCreate(productCreateDto);
        return resultVO;
    }

    @ApiOperation(value = "修改產品",notes = "根據產品編號修改內容")
    @PutMapping("/update")
    public ResultVO update(@RequestBody ProductUpdateDto productUpdateDto){
        ResultVO resultVO = productService.prodUpdate(productUpdateDto);
        return resultVO;
    }

    @ApiOperation(value = "刪除產品",notes = "根據產品編號刪除一個產品")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "成功")})
    @ApiImplicitParam( name="prodId", value = "產品編號", required = true)
    @DeleteMapping("/delete")
    public ResultVO deleteOne(@RequestParam(value = "prodId")String prodId){
        ResultVO resultVO = productService.prodDelete(prodId);
        return resultVO;
    }

    @GetMapping("/page")
    @ApiOperation(value = "條件分頁查詢", notes = "輸入Page、Limit及條件")
    @ApiImplicitParams({
            @ApiImplicitParam(name="limit",value="筆數(頁)",required = true),
            @ApiImplicitParam(name="page",value="當前頁數",required = true),
            @ApiImplicitParam(name="prodName",value="產品名稱"),
            @ApiImplicitParam(name="compName",value="供應商名稱")


    })
    public ResultVO page(@RequestParam(value = "limit") Integer limit,
                         @RequestParam(value = "page") Integer page,
                         @RequestParam(value = "prodName") String prodName,
                         @RequestParam(value = "prodName") String compName){
        ResultVO resultVO = productService.prodPagination(limit, page,prodName,compName);
        return resultVO;

    }

}
