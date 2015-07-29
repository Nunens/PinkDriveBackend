/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.dto;

import com.pinkd.data.CancerType;
import com.pinkd.data.Symptom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sipho
 */
public class CancerTypeDTO {

    private int cancerID;
    private String name;
    private long date;
    private String status;
    private int adminID;
    private List<SymptomDTO> symptomList;

    public CancerTypeDTO() {

    }

    public CancerTypeDTO(CancerType a) {
        cancerID = a.getCancerID();
        name = a.getName();
        date = a.getDate().getTime();
        status = a.getStatus();
        adminID = a.getAdmin().getAdminID();
        if (a.getSymptomList() != null) {
            symptomList = new ArrayList<SymptomDTO>();
            for (Symptom s : a.getSymptomList()) {
                symptomList.add(new SymptomDTO(s));
            }
        }
    }

    public int getCancerID() {
        return cancerID;
    }

    public void setCancerID(int cancerID) {
        this.cancerID = cancerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<SymptomDTO> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<SymptomDTO> symptomList) {
        this.symptomList = symptomList;
    }

}
