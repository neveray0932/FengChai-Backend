package com.neveray0932.fengchai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Customer;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface ICustomerService extends IService<Customer> {

    ResultVO custCreate(Customer customer);

    ResultVO custUpdate(Customer customer);

    ResultVO custDelete(Integer custId );

    ResultVO custFindAll();

    ResultVO custPagination(Integer limit, Integer page, String custName);

}
