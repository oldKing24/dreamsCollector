package com.example.demo.utils;

import java.util.HashMap;

public class RestResponse extends HashMap<String,Object> {
    public static RestResponse success(){
        return success("操作成功");
    }

    public static RestResponse successData(Object data){
        return success("操作成功",data);
    }
    public static RestResponse success(String message, Object data){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess("0");
        restResponse.setMessage(message);
        restResponse.setData(data);
        return restResponse;
    }

    public static RestResponse success(String message){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess("0");
        restResponse.setMessage(message);
        return restResponse;
    }
    public static RestResponse failure(String message){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess("-1");
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse failure(String message, Object data){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess("-1");
        restResponse.setMessage(message);
        restResponse.setData(data);
        return restResponse;
    }

    public RestResponse setSuccess(String code) {
        if (code != null) put("code", code);
        return this;
    }

    public RestResponse setMessage(String message) {
        if (message != null) put("message", message);
        return this;
    }
    public RestResponse setData(Object data) {
        if (data != null) put("data", data);
        return this;
    }
}
