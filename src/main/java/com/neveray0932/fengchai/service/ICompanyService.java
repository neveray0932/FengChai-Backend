package com.neveray0932.fengchai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Company;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface ICompanyService extends IService<Company> {

    ResultVO compCreate(Company company);

    ResultVO compUpdate(Company company);

    ResultVO compDelete(Integer compId );

    ResultVO compFindAll();

    Integer compGetId(String compName);

}
