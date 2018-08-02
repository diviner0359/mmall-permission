package com.mmall.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Diviner on 2018/7/31.
 */
public class LevelUtil {

    //0.1.1
    //0.1.2
    public static final String SEPARATOR = ".";
    public static final String ROOT = "0";
    public static String calculateLevel(String parentLevel,int parentId){
        if (StringUtils.isBlank(parentLevel)){
            return ROOT;
        } else {
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }
}
