package com.neveray0932.fengchai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Supplier;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface ISupplierService extends IService<Supplier> {

    ResultVO supplierCreate(Supplier supplier);

    ResultVO supplierUpdate(Supplier supplier);

    ResultVO supplierDelete(Integer supplierId );

    ResultVO supplierFindAll();

    ResultVO supplierPagination(Integer limit, Integer page, String supplierName);

}
