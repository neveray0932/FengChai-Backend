package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Depository;
import com.baomidou.mybatisplus.extension.service.IService;

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
    ResultVO depositoryDelete(String depId);
    ResultVO depositoryFindAll();

}
