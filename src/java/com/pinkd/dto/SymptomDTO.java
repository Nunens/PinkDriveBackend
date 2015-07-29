/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.dto;

import com.pinkd.data.Symptom;

/**
 *
 * @author Sipho
 */
public class SymptomDTO {

    private int symptomID;
    private String description;
    private long date;
    private String status;
    private int cancerID;

    public SymptomDTO() {

    }

    public SymptomDTO(Symptom a) {
        symptomID = a.getSymptomID();
        description = a.getDescription();
        date = a.getDate().getTime();
        status = a.getStatus();
        cancerID = a.getCancerType().getCancerID();
    }

    public int getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(int symptomID) {
        this.symptomID = symptomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getCancerID() {
        return cancerID;
    }

    public void setCancerID(int cancerID) {
        this.cancerID = cancerID;
    }
}
