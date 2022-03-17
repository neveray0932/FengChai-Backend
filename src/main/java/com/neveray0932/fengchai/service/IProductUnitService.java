package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.ProductUnit;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface IProductUnitService extends IService<ProductUnit> {

    ResultVO prodUnitCreate(ProductUnit productUnit);
    ResultVO prodUnitUpdate(ProductUnit productUnit);
    ResultVO prodUnitDelete(Integer pUnitId);
    ResultVO prodUnitFindAll();
    Integer prodUnitGetId(String prodUnitName);

}
