package com.mmall.service;

import com.mmall.beans.PageQuery;
import com.mmall.beans.PageResult;
import com.mmall.model.SysAcl;
import com.mmall.param.AclParam;

/**
 * Created by Diviner on 2018/9/25.
 */
public interface SysAclService {
    void save(AclParam aclParam);
    void update(AclParam aclParam);
    PageResult<SysAcl> getPageByAclModuleId(int aclModuleId, PageQuery page);
}
