package com.mmall.dto;

import com.google.common.collect.Lists;
import com.mmall.model.SysAclModule;
import com.mmall.model.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * Created by Diviner on 2018/9/23.
 */
@Getter
@Setter
@ToString
public class AclModuleLevelDto extends SysAclModule{
    private List<AclModuleLevelDto> aclModuleList = Lists.newArrayList();
    private List<AclDto> aclList = Lists.newArrayList();
    public static AclModuleLevelDto adapt(SysAclModule aclModule) {
        AclModuleLevelDto dto = new AclModuleLevelDto();
        BeanUtils.copyProperties(aclModule, dto);
        return dto;
    }
}
