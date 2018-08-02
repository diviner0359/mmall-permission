package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Diviner on 2018/7/31.
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    //请求准备进来实现的时候，放在处理之前的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start.url:{},param:{}",url, JsonMapper.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    //请求正常结束之后，会调用这个方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        long start = (Long)request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request finished.url:{},param:{},cost:{}",url, JsonMapper.obj2String(parameterMap),end -start);*/
    }

    //请求结束之后，会调用该方法，在任何情况下都会调用（包括异常）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        long start = (Long)request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request complete.url:{},param:{},cost:{}",url, JsonMapper.obj2String(parameterMap), end - start);
    }
}
