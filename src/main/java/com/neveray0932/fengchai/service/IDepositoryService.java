package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Depository;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.entity.ProductUnit;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface IDepositoryService extends IService<Depository> {

    ResultVO depositoryCreate(Depository depository);
    ResultVO depositoryUpdate(Depository depository);
    ResultVO depositoryDelete(Integer depId);
    ResultVO depositoryFindAll();

}
