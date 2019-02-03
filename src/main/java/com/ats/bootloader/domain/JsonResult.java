package com.ats.bootloader.domain;

public class JsonResult  {
    private Object data;
    private int code;
    private String msg;

    private final static int ERROR_CODE = 400;
    private final static int SUCCESS_CODE = 200;

    private final static String ERROR_MESSAGE = "fail";
    private final static String SUCCESS_MESSAGE = "success";

    public JsonResult(){

    }

    public JsonResult(Object data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static JsonResult success(Object data) {
        return new JsonResult(data, SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static JsonResult error(Object data) {
        return new JsonResult(data, ERROR_CODE, ERROR_MESSAGE);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
}
