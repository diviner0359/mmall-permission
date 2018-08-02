package com.mmall.controller;

import com.mmall.common.ApplicationContextHelper;
import com.mmall.common.JsonResult;
import com.mmall.dao.SysAclModuleMapper;
import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import com.mmall.model.SysAclModule;
import com.mmall.param.TestVo;
import com.mmall.util.BeanValidator;
import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Diviner on 2018/7/20.
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonResult hello(){
        log.info("hello");
        throw new RuntimeException("test exception");
        //return JsonResult.success("hello permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonResult hello(TestVo vo) throws ParamException{
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonResult.success("test validate");
    }
}
