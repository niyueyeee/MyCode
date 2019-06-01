package com.itheima.web.view;

/*
   响应结果类
      就是 前后端定义响应规则

      三个成员
         状态码
         状态码信息
         响应数据
 */
public class Result {

    private int code;
    private String message;
    private Object data;


    /*
    生成两个构造
      一个构造  code message
      一个构造 code message  data
     */

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
