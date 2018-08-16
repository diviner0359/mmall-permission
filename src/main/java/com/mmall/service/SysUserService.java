package com.mmall.service;

import com.mmall.model.SysUser;
import com.mmall.param.UserParam;

/**
 * Created by Diviner on 2018/8/15.
 */
public interface SysUserService {
    void save (UserParam param);
    void update (UserParam param);
    SysUser findByKeyword(String keyword);
}
