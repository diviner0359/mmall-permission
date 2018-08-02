package com.mmall.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;


/**
 * Created by Diviner on 2018/7/22.
 */
@Slf4j
public class JsonMapper {
    private static ObjectMapper objectMapper=  new ObjectMapper();
    static {
        // config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }

    public static <T> String obj2String(T src){
        if (src == null){
            return null;
        }
        try{
            return src instanceof String ? (String) src :objectMapper.writeValueAsString(src);
        }catch (Exception e){
            log.warn("parse object to String exception,String:{},error:{}",src,e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, TypeReference<T> typeReference){
        if(str == null || typeReference == null){
            return null;
        }
        try{
            return (T)(typeReference.getType().equals(String.class)?str:objectMapper.readValue(str,typeReference));
        }catch (Exception e){
            log.warn("parse String to Object exception,String:{},TypeReference<T>:{},error:{}",str,typeReference.getType(),e);
            return null;
        }
    }
}
