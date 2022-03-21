package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.dto.product.ProductCreateDto;
import com.neveray0932.fengchai.common.dto.product.ProductUpdateDto;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface IProductService extends IService<Product> {

    ResultVO prodCreate(ProductCreateDto productCreateDto);
    ResultVO prodUpdate(ProductUpdateDto productUpdateDto);
    ResultVO prodDelete(String prodId);
    ResultVO prodFindAll();
    ResultVO prodPagination(Integer limit, Integer page, String pName, String supplierName);

}
