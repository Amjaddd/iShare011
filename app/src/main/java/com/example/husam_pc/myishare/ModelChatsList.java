package com.example.husam_pc.myishare;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by husam_pc on 23/12/2017.
 */

public class ModelChatsList {
    private String userSend;
    private String message;
    private String timeMessage;


    public ModelChatsList(String userSend, String message) {
        this.userSend = userSend;
        this.message = message;
        this.timeMessage = getCurrenTime();
    }
    private String getCurrenTime(){
        Date date = new Date();
        String currentTime= DateFormat.getTimeInstance(DateFormat.SHORT).format(date);
        return currentTime;

    }

    public String getUserSend() {
        return userSend;
    }

    public void setUserSend(String userSend) {
        this.userSend = userSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(String

                                       timeMessage) {
        this.timeMessage = timeMessage;
    }
}
