package com.bridgelabz.addressbookapp.constants;

public enum ExceptionMsg {
    NOT_FOUND("No Contact Found with ID : ");

    public final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }
}
