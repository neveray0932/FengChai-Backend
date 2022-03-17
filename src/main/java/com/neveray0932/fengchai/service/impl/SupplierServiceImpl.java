package com.neveray0932.fengchai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neveray0932.fengchai.common.dto.*;
import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.common.dto.supplier.SupplierCreateDto;
import com.neveray0932.fengchai.common.dto.supplier.SupplierFindOneDto;
import com.neveray0932.fengchai.common.dto.supplier.SupplierUpdateDto;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.Supplier;
import com.neveray0932.fengchai.mapper.SupplierMapper;
import com.neveray0932.fengchai.service.ISupplierService;
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
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {


    @Override
    public ResultVO supplierCreate(Supplier supplier) {



        boolean save = save(supplier);

//        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Company::getCompName,company.getCompName());
//        Company one = getOne(queryWrapper);

        DTOEntity dtoEntity = new DtoUtils().convertToDto(supplier, new SupplierCreateDto());

        if(save){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_INSERT, dtoEntity);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT, false);


    }

    @Override
    public ResultVO supplierUpdate(Supplier supplier) {

        DTOEntity dtoEntity = new DtoUtils().convertToDto(supplier, new SupplierUpdateDto());

        boolean update = updateById(supplier);
        if (update){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_UPDATED, dtoEntity);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED, null);


    }

    @Override
    public ResultVO supplierDelete(Integer supplierId) {
        boolean remove = removeById(supplierId);
        if(remove){
            return new ResultVO(HttpStatus.OK.value(),ResultMsg.SUCCESS_DELETED,true );
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_DELETED,false);


    }

    @Override
    public ResultVO supplierFindAll() {
        List<Supplier> suppliers = list();
        List<DTOEntity> list = new DtoUtils().convertToDtoList(suppliers, new SupplierFindOneDto());


        if(!suppliers.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,list);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_QUERY,null);


    }
}
