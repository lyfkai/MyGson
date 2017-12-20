package com.tjhq.mygson.evenbus.demo1;

/**
 * Created by pc on 2017/12/14.
 */

public class UpdateUiEvent {
    private String ms;
    public UpdateUiEvent(String msf) {
        this.ms = msf;
    }
    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }
    
}
