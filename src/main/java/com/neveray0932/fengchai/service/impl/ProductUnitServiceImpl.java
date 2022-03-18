package com.neveray0932.fengchai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neveray0932.fengchai.common.vo.ResultMsg;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.ProductUnit;
import com.neveray0932.fengchai.mapper.ProductUnitMapper;
import com.neveray0932.fengchai.service.IProductUnitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class ProductUnitServiceImpl extends ServiceImpl<ProductUnitMapper, ProductUnit> implements IProductUnitService {

    @Override
    public ResultVO prodUnitCreate(ProductUnit productUnit) {
        boolean save = save(productUnit);
        if (save){
            return new ResultVO(HttpStatus.CREATED.value(), ResultMsg.SUCCESS_INSERT,productUnit);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT,null);


    }

    @Override
    public ResultVO prodUnitUpdate(ProductUnit productUnit) {
        boolean update = updateById(productUnit);
        if (update){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_UPDATED,productUnit );
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED,null );


    }

    @Override
    public ResultVO prodUnitDelete(Integer pUnitId) {
        boolean remove = removeById(pUnitId);
        if (remove){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETED,true);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.SUCCESS_DELETED,false);


    }

    @Override
    public ResultVO prodUnitFindAll() {
        List<ProductUnit> productUnits = list();
        if (!productUnits.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,productUnits);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);


    }

    @Override
    public Integer prodUnitGetId(String prodUnitName) {
        QueryWrapper<ProductUnit> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ProductUnit::getPunitName,prodUnitName);
        ProductUnit productUnit = getOne(queryWrapper);
        return productUnit.getPunitId();
    }
}
