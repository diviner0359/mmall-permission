package com.mmall.controller;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mmall.common.JsonResult;
import com.mmall.model.SysUser;
import com.mmall.param.RoleParam;
import com.mmall.service.*;
import com.mmall.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Diviner on 2018/11/21.
 */
@Controller
@RequestMapping("/sys/role")
@Slf4j
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysTreeService sysTreeService;
    @Autowired
    private SysRoleAclService sysRoleAclService;
    @Autowired
    private SysRoleUserService sysRoleUserService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonResult saveRole(RoleParam param){
        sysRoleService.save(param);
        return JsonResult.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonResult updateRole(RoleParam param){
        sysRoleService.update(param);
        return JsonResult.success();
    }

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonResult list(){
        return JsonResult.success(sysRoleService.getAll());
    }

    @RequestMapping("/role.page")
    public ModelAndView page(){
        return new ModelAndView("role");
    }

    @RequestMapping("/roleTree.json")
    @ResponseBody
    public JsonResult roleTree(@RequestParam("roleId") int roleId){
        return JsonResult.success(sysTreeService.roleTree(roleId));
    }

    @RequestMapping("/changeAcls.json")
    @ResponseBody
    public JsonResult changeAcls(@RequestParam("roleId") int roleId,@RequestParam(value = "aclIds",required = false,defaultValue = "") String aclIds){
        List<Integer> aclIdList = StringUtil.splitToListInt(aclIds);
        sysRoleAclService.changeRoleAcls(roleId,aclIdList);
        return JsonResult.success();
    }

    @RequestMapping("/users.json")
    @ResponseBody
    public JsonResult users(@RequestParam("roleId") int roleId){
        List<SysUser> selectedUserList = sysRoleUserService.getListByRoleId(roleId);
        List<SysUser> allUserList = sysUserService.getAll();
        List<SysUser> unselectedUserList = Lists.newArrayList();

        Set<Integer> selectedUserIdSet = selectedUserList.stream().map(sysUser -> sysUser.getId()).collect(Collectors.toSet());
        for(SysUser sysUser : allUserList){
            if(sysUser.getStatus() == 1 &&  !selectedUserIdSet.contains(sysUser.getId())/* 效率低 !selectedUserList.contains(sysUser)*/){
                unselectedUserList.add(sysUser);
            }
        }
        //当状态不等于1时过滤掉
        //selectedUserList = selectedUserList.stream().filter(sysUser -> sysUser.getId() != 1).collect(Collectors.toList());
        Map<String,List<SysUser>> map = Maps.newHashMap();
        map.put("selected",selectedUserList);
        map.put("unselected",unselectedUserList);
        return JsonResult.success(map);
    }


}
