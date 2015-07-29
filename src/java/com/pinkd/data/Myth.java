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
@Table(name = "myth", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Myth.findAll", query = "SELECT m FROM Myth m"),
    @NamedQuery(name = "Myth.findByMythID", query = "SELECT m FROM Myth m WHERE m.mythID = :mythID"),
    @NamedQuery(name = "Myth.findByContent", query = "SELECT m FROM Myth m WHERE m.content = :content"),
    @NamedQuery(name = "Myth.findByDate", query = "SELECT m FROM Myth m WHERE m.date = :date"),
    @NamedQuery(name = "Myth.findByStatus", query = "SELECT m FROM Myth m WHERE m.status = :status")})
public class Myth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mythID")
    private Integer mythID;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne(optional = false)
    private Admin admin;

    public Myth() {
    }

    public Myth(Integer mythID) {
        this.mythID = mythID;
    }

    public Integer getMythID() {
        return mythID;
    }

    public void setMythID(Integer mythID) {
        this.mythID = mythID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mythID != null ? mythID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Myth)) {
            return false;
        }
        Myth other = (Myth) object;
        if ((this.mythID == null && other.mythID != null) || (this.mythID != null && !this.mythID.equals(other.mythID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Myth[ mythID=" + mythID + " ]";
    }
    
}
