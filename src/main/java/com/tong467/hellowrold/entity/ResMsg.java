package com.tong467.hellowrold.entity;

public class ResMsg<T> {

    private int code;
    private String msg;
    private T data;

    public ResMsg(){
        code = 0;
        msg = "成功";
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
