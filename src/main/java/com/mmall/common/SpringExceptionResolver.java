package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Diviner on 2018/7/22.
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";

        /*
        * .json,  .page
        * 这里我们要求项目中所有请求json数据，都使用.json结尾。
        * 这里我们要求项目中所有请求page页面，都使用.page结尾。
        * */
        if(url.endsWith(".json")){
            if(ex instanceof PermissionException || ex instanceof ParamException){
                JsonResult jsonResult = JsonResult.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",jsonResult.toMap());
            } else {
                log.error("unknow json exception,url:" + url,ex);
                JsonResult jsonResult = JsonResult.fail(defaultMsg);
                mv = new ModelAndView("jsonView",jsonResult.toMap());
            }
        } else if(url.endsWith(".page")){
            log.error("unknow page exception,url:" + url,ex);
            JsonResult jsonResult = JsonResult.fail(defaultMsg);
            mv = new ModelAndView("exception",jsonResult.toMap());
        } else {
            log.error("unknow exception,url:" + url,ex);
            JsonResult jsonResult = JsonResult.fail(defaultMsg);
            mv = new ModelAndView("jsonView",jsonResult.toMap());
        }
        return mv;
    }
}
