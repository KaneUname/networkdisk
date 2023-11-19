package com.nwd.util;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer status;

    private String message;

    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    /**
     * 设定结果为成功
     * @param message
     */
    public void setRusultSuccess(String message){
        this.status = ResulfCode.SUCCESS.status();
        this.message= message;
        this.data=null;
    }

    /**
     * 设定结果为成功数据类
     * @param msg
     * @param data
     */
    public void setResultSuccess(String msg, T data) {
        this.message = msg;
        this.status = ResulfCode.SUCCESS.status();
        this.data = data;
    }

    /**
     * 设定结果为失败
     *
     * @param msg 消息
     */
    public void setResultFailed(String msg) {
        this.message = msg;
        this.status = ResulfCode.EORROR.status();
        this.data = null;
    }

    public Result() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void setData(T data) {
        this.data = data;
    }
}
