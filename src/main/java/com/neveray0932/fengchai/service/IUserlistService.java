package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.Vo.ResultVO;
import com.neveray0932.fengchai.entity.Userlist;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
public interface IUserlistService extends IService<Userlist> {

    ResultVO userRegister(Userlist userlist);
    ResultVO userLogin(Userlist userlist);

}
