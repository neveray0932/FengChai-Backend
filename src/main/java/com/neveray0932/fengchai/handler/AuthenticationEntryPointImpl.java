package com.neveray0932.fengchai.handler;

import com.alibaba.fastjson.JSON;
import com.neveray0932.fengchai.common.utils.WebUtils;
import com.neveray0932.fengchai.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResultVO resultVO = new ResultVO(HttpStatus.UNAUTHORIZED.value(),"用戶認證失敗請重新登入");
        String s = JSON.toJSONString(resultVO);
        //處裡異常
        WebUtils.renderString(response,s);
    }
}
