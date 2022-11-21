package com.mayikt.common.core.api.constants;

/**
* Api接口返回枚举类
*/
public enum ApiConstants {
    HTTP_RES_CODE_200(200, "ok"),
    HTTP_RES_CODE_500(500, "fail");
    private Integer code;
    private String value;
    
    ApiConstants(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}