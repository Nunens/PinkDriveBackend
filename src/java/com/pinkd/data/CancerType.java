/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sipho
 */
@Entity
@Table(name = "cancer_type", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CancerType.findAll", query = "SELECT c FROM CancerType c"),
    @NamedQuery(name = "CancerType.findByCancerID", query = "SELECT c FROM CancerType c WHERE c.cancerID = :cancerID"),
    @NamedQuery(name = "CancerType.findByName", query = "SELECT c FROM CancerType c WHERE c.name = :name"),
    @NamedQuery(name = "CancerType.findByDate", query = "SELECT c FROM CancerType c WHERE c.date = :date"),
    @NamedQuery(name = "CancerType.findByStatus", query = "SELECT c FROM CancerType c WHERE c.status = :status")})
public class CancerType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cancerID")
    private Integer cancerID;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne
    private Admin admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cancerType")
    private List<Exam> examList;
    @OneToMany(mappedBy = "cancerType")
    private List<Symptom> symptomList;

    public CancerType() {
    }

    public CancerType(Integer cancerID) {
        this.cancerID = cancerID;
    }

    public Integer getCancerID() {
        return cancerID;
    }

    public void setCancerID(Integer cancerID) {
        this.cancerID = cancerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @XmlTransient
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @XmlTransient
    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancerID != null ? cancerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CancerType)) {
            return false;
        }
        CancerType other = (CancerType) object;
        if ((this.cancerID == null && other.cancerID != null) || (this.cancerID != null && !this.cancerID.equals(other.cancerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.CancerType[ cancerID=" + cancerID + " ]";
    }
    
}
