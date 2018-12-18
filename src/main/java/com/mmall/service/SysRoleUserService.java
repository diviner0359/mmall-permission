package com.mmall.service;

import com.mmall.model.SysUser;

import java.util.List;

/**
 * Created by Diviner on 2018/12/18.
 */
public interface SysRoleUserService {
    List<SysUser> getListByRoleId(int roleId);
}
