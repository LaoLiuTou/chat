package com.lt.chat.token;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger("Logger");
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {


        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        try {
            // 执行认证
            if (token == null) {
                logger.info("无token，请重新登录");
                responseMessage(httpServletResponse, "无token，请重新登录");
                return false;
            }
            // 获取 token 中的 user id
            String userId = JWT.decode(token).getAudience().get(0);
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userId)).build();
            jwtVerifier.verify(token);
            return true;

        } catch (Exception e) {
            responseMessage(httpServletResponse,  "token验证出错！");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView)  {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) {
    }


    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response,  String  message) throws IOException {
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out=response.getWriter();
        Map<String, String> result= new HashMap<>();
        result.put("state","-1");
        result.put("msg",message);
        ObjectMapper objectMapper = new ObjectMapper();
        out.print(objectMapper.writeValueAsString(result));
        out.flush();
        out.close();
    }
}
