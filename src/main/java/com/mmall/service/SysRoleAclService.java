package com.mmall.service;

import java.util.List;

/**
 * Created by Diviner on 2018/12/18.
 */
public interface SysRoleAclService {
    void changeRoleAcls(Integer RoleId, List<Integer> aclIdList);
}
