package com.neveray0932.fengchai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neveray0932.fengchai.common.dto.*;
import com.neveray0932.fengchai.common.dto.customer.CustomerCreateDto;
import com.neveray0932.fengchai.common.dto.customer.CustomerFindOneDto;
import com.neveray0932.fengchai.common.dto.customer.CustomerUpdateDto;
import com.neveray0932.fengchai.common.Vo.ResultMsg;
import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.common.utils.DtoUtils;
import com.neveray0932.fengchai.entity.Customer;
import com.neveray0932.fengchai.mapper.CustomerMapper;
import com.neveray0932.fengchai.service.ICustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public ResultVO custCreate(Customer customer) {
        boolean save = save(customer);

        DTOEntity dtoEntity = new DtoUtils().convertToDto(customer, new CustomerCreateDto());

        if(save){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_INSERT,dtoEntity);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_INSERT,dtoEntity);


    }

    @Override
    public ResultVO custUpdate(Customer customer) {
        boolean update = false;
        if(customer.getCustId()!=null){
            update = updateById(customer);
        }

        DTOEntity dtoEntity = new DtoUtils().convertToDto(customer, new CustomerUpdateDto());
        if(update){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_UPDATED,dtoEntity);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_UPDATED,null);


    }

    @Override
    public ResultVO custDelete(Integer custId) {
        boolean remove = false;

        Customer customer = new Customer();
        customer.setCustId(custId);
        customer.setDelFlag(1);

        if (custId!=null){
            remove = updateById(customer);
        }

        if(remove){
            Customer id = getById(custId);
            DTOEntity dtoEntity = new DtoUtils().convertToDto(id, new CustomerFindOneDto());
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_DELETED,dtoEntity);
        }

            return new ResultVO(HttpStatus.NO_CONTENT.value(), ResultMsg.FAILED_DELETED,false);


    }

    @Override
    public ResultVO custFindAll() {
        List<Customer> customerList = list();
        List<DTOEntity> dtoList = new DtoUtils().convertToDtoList(customerList, new CustomerFindOneDto());
        if (!customerList.isEmpty()){
            return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,dtoList);
        }
            return new ResultVO(HttpStatus.NO_CONTENT.value(),ResultMsg.FAILED_QUERY,null);


    }

    @Override
    public ResultVO custPagination(Integer limit, Integer page,String custName) {

        PageDto pageDto = new PageDto();
        String trimCustName = custName.trim();

        IPage<Customer> iPage = new Page<>(page,limit);
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Customer::getCustName,trimCustName);
        IPage<Customer> customerIPage = getBaseMapper().selectPage(iPage, queryWrapper);
        List<DTOEntity> dtoList = new DtoUtils().convertToDtoList(customerIPage.getRecords(), new CustomerFindOneDto());
        pageDto.setRecords(dtoList);
        pageDto.setTotal(customerIPage.getTotal());

        return new ResultVO(HttpStatus.OK.value(), ResultMsg.SUCCESS_QUERY,pageDto);
    }
}
