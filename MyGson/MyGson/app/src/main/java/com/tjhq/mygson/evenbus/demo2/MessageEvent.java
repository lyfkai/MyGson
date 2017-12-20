package com.tjhq.mygson.evenbus.demo2;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
