package com.neveray0932.fengchai.handler;

import com.alibaba.fastjson.JSON;
import com.neveray0932.fengchai.common.utils.WebUtils;
import com.neveray0932.fengchai.common.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResultVO resultVO = new ResultVO(HttpStatus.FORBIDDEN.value(), "您的權限不足");
        String s = JSON.toJSONString(resultVO);
        WebUtils.renderString(response,s);
    }
}
