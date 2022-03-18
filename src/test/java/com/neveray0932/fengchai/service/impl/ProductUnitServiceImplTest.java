package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.ProductUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class ProductUnitServiceImplTest {

    @Autowired
    ProductUnitServiceImpl productUnitService;

    @Test
    void prodUnitCreate() {
        ProductUnit productUnit = new ProductUnit();
        productUnit.setPunitName("個");
        ResultVO resultVO = productUnitService.prodUnitCreate(productUnit);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    void prodUnitUpdate() {
        ProductUnit productUnit = new ProductUnit();
        productUnit.setPunitId(1);
        productUnit.setPunitName("片");
        ResultVO resultVO = productUnitService.prodUnitUpdate(productUnit);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    void prodUnitDelete() {
        ResultVO resultVO = productUnitService.prodUnitDelete(1);
        System.out.println("resultVO = " + resultVO);
    }

    @Test
    void prodUnitFindAll() {
        ResultVO resultVO = productUnitService.prodUnitFindAll();
        System.out.println("resultVO = " + resultVO);
    }
}