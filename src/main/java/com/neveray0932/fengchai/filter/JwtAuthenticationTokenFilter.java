package com.neveray0932.fengchai.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neveray0932.fengchai.common.dto.role.FindUserRoleDto;
import com.neveray0932.fengchai.entity.UserTemp;
import com.neveray0932.fengchai.service.impl.UserTempServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    UserTempServiceImpl userTempService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //獲取token
        String token = request.getHeader(AUTHORIZATION);
        if(!StringUtils.hasText(token)){
            //放行
            filterChain.doFilter(request,response);
            //阻止這個為空的token繼續往下面請求
            return;
        }
        //解析token
        Object empId;
        List<String> role;
        try{
            Jws<Claims> jws = Jwts.parser().setSigningKey("fengchai6666").parseClaimsJws(token);
            empId = jws.getBody().get("empId");
            role = (List<String>) jws.getBody().get("role");



        }catch (Exception e){
//            response.setHeader("error", e.getMessage());
//            response.setStatus(FORBIDDEN.value());
//            Map<String, String> error = new HashMap<>();
//            error.put("message", e.getMessage());
//            response.setContentType("application/json");
//            new ObjectMapper().writeValue(response.getOutputStream(), error);
            throw new RuntimeException("token非法");

        }

        //從redis中獲取用戶信息
        QueryWrapper<UserTemp> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserTemp::getEmpId,empId);
        UserTemp temp = userTempService.getOne(queryWrapper);
        if(Objects.isNull(temp)){
            throw new RuntimeException("帳號未登入");
        }
        //存入SecurityContextHolder
        //TODO 獲取權限信息封裝到Authentication中
//        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
//        role.stream().forEach((res->{
//            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(res));
//        }));




        ;

        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(temp,null,null);
                new UsernamePasswordAuthenticationToken(temp,null,role.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //放行
        filterChain.doFilter(request,response);

    }
}
