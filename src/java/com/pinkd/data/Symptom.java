/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sipho
 */
@Entity
@Table(name = "symptom", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Symptom.findAll", query = "SELECT s FROM Symptom s"),
    @NamedQuery(name = "Symptom.findBySymptomID", query = "SELECT s FROM Symptom s WHERE s.symptomID = :symptomID"),
    @NamedQuery(name = "Symptom.findByDescription", query = "SELECT s FROM Symptom s WHERE s.description = :description"),
    @NamedQuery(name = "Symptom.findByDate", query = "SELECT s FROM Symptom s WHERE s.date = :date"),
    @NamedQuery(name = "Symptom.findByStatus", query = "SELECT s FROM Symptom s WHERE s.status = :status")})
public class Symptom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "symptomID")
    private Integer symptomID;
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "cancerID", referencedColumnName = "cancerID")
    @ManyToOne
    private CancerType cancerType;

    public Symptom() {
    }

    public Symptom(Integer symptomID) {
        this.symptomID = symptomID;
    }

    public Integer getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(Integer symptomID) {
        this.symptomID = symptomID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CancerType getCancerType() {
        return cancerType;
    }

    public void setCancerType(CancerType cancerType) {
        this.cancerType = cancerType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (symptomID != null ? symptomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Symptom)) {
            return false;
        }
        Symptom other = (Symptom) object;
        if ((this.symptomID == null && other.symptomID != null) || (this.symptomID != null && !this.symptomID.equals(other.symptomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Symptom[ symptomID=" + symptomID + " ]";
    }
    
}
