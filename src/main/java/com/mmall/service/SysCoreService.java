package com.mmall.service;

import com.mmall.model.SysAcl;

import java.util.List;

/**
 * Created by Diviner on 2018/12/6.
 */
public interface SysCoreService {
    List<SysAcl> getCurrentUserAclList();
    List<SysAcl> getRoleAclList(int roleId);
}
