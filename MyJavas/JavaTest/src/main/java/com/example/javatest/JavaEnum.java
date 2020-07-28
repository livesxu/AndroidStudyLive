package com.example.javatest;

public enum JavaEnum {

    ENUMONE(1,"第一枚举"),
    ENUMTWO(2,"第二枚举"),
    ENUMTHREE(3,"第三枚举");

    private int code;
    private String msg;

    JavaEnum(int code,String msg) {

        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
