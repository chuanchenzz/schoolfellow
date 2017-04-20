package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/20.
 */
public class JsonResult {
    private int statusCode;
    private String message;
    public JsonResult(){

    }

    public JsonResult(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
