/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.dto;

import com.pinkd.data.Calender;

/**
 *
 * @author Sipho
 */
public class CalenderDTO {

    private int calenderID;
    private long mDate;
    private long date;
    private String status;
    private int userID;

    public CalenderDTO() {

    }

    public CalenderDTO(Calender a) {
        calenderID = a.getCalenderID();
        mDate = a.getMDate().getTime();
        date = a.getDate().getTime();
        status = a.getStatus();
        userID = a.getUser().getUserID();
    }

    public int getCalenderID() {
        return calenderID;
    }

    public void setCalenderID(int calenderID) {
        this.calenderID = calenderID;
    }

    public long getmDate() {
        return mDate;
    }

    public void setmDate(long mDate) {
        this.mDate = mDate;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
