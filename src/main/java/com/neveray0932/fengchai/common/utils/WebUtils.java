package com.neveray0932.fengchai.common.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author CADTECH
 */
public class WebUtils {

    public static String renderString(HttpServletResponse response, String string){
        try{

            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
}
