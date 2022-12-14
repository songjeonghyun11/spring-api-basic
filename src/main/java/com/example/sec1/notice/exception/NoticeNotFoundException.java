package com.example.sec1.notice.exception;

public class NoticeNotFoundException extends RuntimeException{
    public NoticeNotFoundException(String message) {
        super(message);
    }
}
