package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.EmpPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.entity.ProductUnit;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-15
 */
public interface IEmpPositionService extends IService<EmpPosition> {

    ResultVO empPositionCreate(EmpPosition empPosition);
    ResultVO empPositionUpdate(EmpPosition empPosition);
    ResultVO empPositionDelete(Integer empPositionId);
    ResultVO empPositionFindAll();
}
