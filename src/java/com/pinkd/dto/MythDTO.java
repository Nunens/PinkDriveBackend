/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.dto;

import com.pinkd.data.Myth;

/**
 *
 * @author Sipho
 */
public class MythDTO {

    private int mythID;
    private String content;
    private long date;
    private String status;
    private int adminID;

    public MythDTO() {

    }

    public MythDTO(Myth a) {
        mythID = a.getMythID();
        content = a.getContent();
        date = a.getDate().getTime();
        status = a.getStatus();
        adminID = a.getAdmin().getAdminID();
    }

    public int getMythID() {
        return mythID;
    }

    public void setMythID(int mythID) {
        this.mythID = mythID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
}
