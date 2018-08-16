package com.mmall.controller;

import com.mmall.common.JsonResult;
import com.mmall.param.DeptParam;
import com.mmall.param.UserParam;
import com.mmall.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Diviner on 2018/8/15.
 */
@Controller
@RequestMapping("sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonResult saveUser(UserParam param){
        sysUserService.save(param);
        return JsonResult.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonResult updateUser(UserParam param){
        sysUserService.update(param);
        return JsonResult.success();
    }
}
