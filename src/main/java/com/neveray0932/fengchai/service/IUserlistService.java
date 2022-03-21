package com.neveray0932.fengchai.service;

import com.neveray0932.fengchai.common.vo.ResultVO;
import com.neveray0932.fengchai.entity.Userlist;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    ResultVO userLogout();
    ResultVO refreshToken(String authorization);


}
