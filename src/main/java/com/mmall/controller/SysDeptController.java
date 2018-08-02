package com.mmall.controller;

import com.mmall.common.JsonResult;
import com.mmall.dto.DeptLevelDto;
import com.mmall.param.DeptParam;
import com.mmall.service.SysDeptService;
import com.mmall.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Diviner on 2018/7/31.
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;
    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/dept.page")
    public ModelAndView page(){
        return new ModelAndView("dept");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonResult saveDept(DeptParam param){
        sysDeptService.save(param);
        return JsonResult.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonResult tree(){
        List<DeptLevelDto> dtoList = sysTreeService.deptTree();
        return JsonResult.success(dtoList);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonResult updateDept(DeptParam param){
        sysDeptService.update(param);
        return JsonResult.success();
    }

}
