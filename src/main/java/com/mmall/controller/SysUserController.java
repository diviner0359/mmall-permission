package com.mmall.controller;

import com.google.common.collect.Maps;
import com.mmall.beans.PageQuery;
import com.mmall.beans.PageResult;
import com.mmall.common.JsonResult;
import com.mmall.model.SysUser;
import com.mmall.param.DeptParam;
import com.mmall.param.UserParam;
import com.mmall.service.SysRoleService;
import com.mmall.service.SysTreeService;
import com.mmall.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Diviner on 2018/8/15.
 */
@Controller
@RequestMapping("sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Autowired
    private SysTreeService sysTreeService;
    @Autowired
    private SysRoleService sysRoleService;

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

    @RequestMapping("/page.json")
    @ResponseBody
    public JsonResult page(@RequestParam("deptId") int deptId, PageQuery pageQuery) {
        PageResult<SysUser> result = sysUserService.getPageByDeptId(deptId, pageQuery);
        return JsonResult.success(result);
    }

    @RequestMapping("/acls.json")
    @ResponseBody
    public JsonResult acls(@RequestParam("userId") int userId){
        Map<String,Object> map = Maps.newHashMap();
        map.put("acls",sysTreeService.userAclTree(userId));
        map.put("roles",sysRoleService.getRoleListByUserId(userId));
        return JsonResult.success(map);
    }
    
}
