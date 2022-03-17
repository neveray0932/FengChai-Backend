package com.neveray0932.fengchai.mapper;

import com.neveray0932.fengchai.common.dto.product.ProductPageDto;
import com.neveray0932.fengchai.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    List<ProductPageDto> findAllProductByPage(Integer limit, Integer page, String pName, String compName );

    ProductPageDto findAllJoin(String prodId);

}
