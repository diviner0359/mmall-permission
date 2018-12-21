package com.mmall.service;

import com.mmall.param.AclModuleParam;

/**
 * Created by Diviner on 2018/8/20.
 */
public interface SysAclModuleService {
    void save(AclModuleParam param);
    void update(AclModuleParam param);
    void delete(int aclModuleId);
}
