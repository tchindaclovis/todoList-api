package com.clovis.todo.exception;

public enum ErrorCodes {
    TASK_NOT_FOUND(1000),
    TASK_NOT_VALID(1001),
    TASK_ALREADY_IN_USE(1002);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
