package com.mmall.service.impl;

import com.google.common.base.Preconditions;
import com.mmall.dao.SysUserMapper;
import com.mmall.exception.ParamException;
import com.mmall.model.SysUser;
import com.mmall.param.UserParam;
import com.mmall.service.SysUserService;
import com.mmall.util.BeanValidator;
import com.mmall.util.MD5Util;
import com.mmall.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Diviner on 2018/8/15.
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;
    public void save (UserParam param){
        BeanValidator.check(param);
        if(checkEmailExist(param.getMail(),param.getId())){
            throw new ParamException("邮箱已被占用");
        }
        if(checkTelephoneExist(param.getTelephone(),param.getId())){
            throw new ParamException("电话已被占用");
        }
        String password = PasswordUtil.randomPassword();
        //TODO:
        password = "12345678";
        String encryptedPassword = MD5Util.encrypt(password);
        SysUser user = SysUser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .password(encryptedPassword).deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        user.setOperator("system");     //TODO
        user.setOperateIp("127.0.0.1");   //TODO
        user.setOperateTime(new Date());
        // TODO: sendEmail

        sysUserMapper.insertSelective(user);
        //sysLogService.saveUserLog(null, user);
    }

    public void update(UserParam param) {
        BeanValidator.check(param);
        if(checkTelephoneExist(param.getTelephone(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if(checkEmailExist(param.getMail(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        SysUser before = sysUserMapper.selectByPrimaryKey(param.getId());
        Preconditions.checkNotNull(before, "待更新的用户不存在");
        SysUser after = SysUser.builder().id(param.getId()).username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail())
                .deptId(param.getDeptId()).status(param.getStatus()).remark(param.getRemark()).build();
        /*after.setOperator(RequestHolder.getCurrentUser().getUsername());
        after.setOperateIp(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperateTime(new Date());*/
        sysUserMapper.updateByPrimaryKeySelective(after);
        //sysLogService.saveUserLog(before, after);
    }

    public boolean checkEmailExist(String mail,Integer userId){
        return sysUserMapper.countByMail(mail, userId)>0;
    }
    public boolean checkTelephoneExist(String phone,Integer userId){
        return sysUserMapper.countByTelephone(phone, userId)>0;
    }
    public SysUser findByKeyword(String keyword) {
        return sysUserMapper.findByKeyword(keyword);
    }

}
