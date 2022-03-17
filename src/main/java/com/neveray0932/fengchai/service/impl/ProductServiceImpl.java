package com.neveray0932.fengchai.service.impl;

import com.neveray0932.fengchai.common.dto.PageDto;
import com.neveray0932.fengchai.common.dto.product.ProductCreateDto;
import com.neveray0932.fengchai.common.dto.product.ProductPageDto;
import com.neveray0932.fengchai.common.dto.product.ProductUpdateDto;
import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Product;
import com.neveray0932.fengchai.mapper.ProductMapper;
import com.neveray0932.fengchai.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    ProductUnitServiceImpl productUnitService;
    @Autowired
    CompanyServiceImpl companyService;

    @Override
    public ResultVO prodCreate(ProductCreateDto productCreateDto) {

        Product id = getById(productCreateDto.getPId());
        if(!Objects.isNull(id)){
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.EXIT,null);
        }

        Integer prodUnitId = productUnitService.prodUnitGetId(productCreateDto.getPUnitName());

        Integer compId = companyService.compGetId(productCreateDto.getCompName());

        Product product= new Product();

        product.setPId(productCreateDto.getPId());
        product.setPName(productCreateDto.getPName());
        product.setPUnitId(prodUnitId);
        product.setPPrice(productCreateDto.getPPrice());
        product.setPCoefficient(productCreateDto.getPCoefficient());
        product.setPCost(productCreateDto.getPCost());
        product.setPSize(productCreateDto.getPSize());
        product.setPCompid(compId);
        product.setPRemark(productCreateDto.getPRemark());
        product.setDelFlag(0);

        boolean save = save(product);
        if (save){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_INSERT,productCreateDto);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT,null);

    }

    @Override
    public ResultVO prodUpdate(ProductUpdateDto productUpdateDto) {

        Integer prodUnitId = productUnitService.prodUnitGetId(productUpdateDto.getPUnitName());

        Integer compId = companyService.compGetId(productUpdateDto.getCompName());

        Product product= new Product();

        product.setPId(productUpdateDto.getPId());
        product.setPName(productUpdateDto.getPName());
        product.setPUnitId(prodUnitId);
        product.setPPrice(productUpdateDto.getPPrice());
        product.setPCoefficient(productUpdateDto.getPCoefficient());
        product.setPCost(productUpdateDto.getPCost());
        product.setPSize(productUpdateDto.getPSize());
        product.setPCompid(compId);
        product.setPRemark(productUpdateDto.getPRemark());
        product.setDelFlag(0);

        boolean update = updateById(product);
        if (update){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_UPDATED,productUpdateDto );
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED,null );

    }

    @Override
    public ResultVO prodDelete(String prodId) {
        Product product = new Product();
        product.setPId(prodId);
        product.setDelFlag(1);
        boolean remove = updateById(product);

        if (remove){
            ProductPageDto allJoin = getBaseMapper().findAllJoin(prodId);
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETED,allJoin);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.SUCCESS_DELETED,false);

    }

    @Override
    public ResultVO prodFindAll() {
        List<Product> products = list();
        if (!products.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,products);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);

    }

    @Override
    public ResultVO prodPagination(Integer limit, Integer page, String prodName,String compName) {

        Integer pages = (page-1)*limit;

        String trimProdName = prodName.trim();
        String trimCompName = compName.trim();

        List<ProductPageDto> productPageDtos = getBaseMapper().findAllProductByPage(limit, pages, trimProdName, trimCompName);

        PageDto pageDto = new PageDto();
        if (trimProdName.length()==0 && trimCompName.length()==0){

            int count = count();
            pageDto.setTotal((long) count);
            pageDto.setRecords(productPageDtos);
        }else{

            pageDto.setTotal((long) productPageDtos.size());
            pageDto.setRecords(productPageDtos);
        }

        return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_QUERY,pageDto);
    }
}
