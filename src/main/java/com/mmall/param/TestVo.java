package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Diviner on 2018/7/22.
 */
@Getter
@Setter
public class TestVo {

    @NotBlank
    private String msg;
    @NotNull
    @Max(value = 10,message = "id不能大于10")
    @Min(value = 0,message = "id至少大于等于0")
    private Integer id;
    //@NotEmpty
    private List<String> str;
}
