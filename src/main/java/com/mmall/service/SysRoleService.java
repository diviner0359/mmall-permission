package com.mmall.service;


import com.mmall.model.SysRole;
import com.mmall.param.RoleParam;

import java.util.List;

/**
 * Created by Diviner on 2018/11/21.
 */
public interface SysRoleService {
    void save(RoleParam param);
    void update(RoleParam param);
    List<SysRole> getAll();
}