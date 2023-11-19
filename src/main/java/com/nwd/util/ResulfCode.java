package com.nwd.util;


public enum ResulfCode {
    SUCCESS(200),
    EORROR(-1);
    private Integer status;

    ResulfCode(Integer status) {
        this.status = status;
    }

    public Integer status(){
        return this.status;
    }






}
