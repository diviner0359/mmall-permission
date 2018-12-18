package com.mmall.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Diviner on 2018/12/18.
 */
public class StringUtil {
    //1,2,a,4 若为这种情况肯定出错，实际中要抛出异常进行捕获！
    //1,2,3,4,,,转换为{1,2,3,4}
    public static List<Integer> splitToListInt(String str){
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }
}
