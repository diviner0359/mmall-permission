package com.mmall.controller;

import com.mmall.beans.PageQuery;
import com.mmall.common.JsonResult;
import com.mmall.param.AclModuleParam;
import com.mmall.param.AclParam;
import com.mmall.service.SysAclService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Diviner on 2018/8/20.
 */
@Controller
@RequestMapping("sys/acl")
@Slf4j
public class SysAclController {
    @Autowired
    private SysAclService sysAclService;
    @RequestMapping("/save.json")
    @ResponseBody
    public JsonResult saveAclModule(AclParam param){
        sysAclService.save(param);
        return JsonResult.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonResult updateAclModule(AclParam param){
        sysAclService.update(param);
        return JsonResult.success();
    }

    @RequestMapping("/page.json")
    @ResponseBody
    public JsonResult list(@RequestParam("aclModuleId") Integer aclModuleId,PageQuery pageQuery){
        return JsonResult.success(sysAclService.getPageByAclModuleId(aclModuleId,pageQuery));
    }
}
