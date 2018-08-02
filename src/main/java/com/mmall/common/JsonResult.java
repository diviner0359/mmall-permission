package com.mmall.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diviner on 2018/7/22.
 */
@Setter
@Getter
public class JsonResult {

    private boolean ret;
    private String msg;
    private  Object data;

    public JsonResult (boolean ret){
        this.ret = ret;
    }
    public static JsonResult success (Object object,String msg){
        JsonResult jsonResult = new JsonResult(true);
        jsonResult.data = object;
        jsonResult.msg = msg;
        return jsonResult;
    }
    public static JsonResult success (Object object){
        JsonResult jsonResult = new JsonResult(true);
        jsonResult.data = object;
        return jsonResult;
    }
    public static JsonResult success (){
        JsonResult jsonResult = new JsonResult(true);
        return jsonResult;
    }
    public static JsonResult fail(String msg){
        JsonResult jsonResult = new JsonResult(false);
        jsonResult.msg = msg;
        return jsonResult;
    }
    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }
}
