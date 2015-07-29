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
@Table(name = "calender", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calender.findAll", query = "SELECT c FROM Calender c"),
    @NamedQuery(name = "Calender.findByCalenderID", query = "SELECT c FROM Calender c WHERE c.calenderID = :calenderID"),
    @NamedQuery(name = "Calender.findByMDate", query = "SELECT c FROM Calender c WHERE c.mDate = :mDate"),
    @NamedQuery(name = "Calender.findByDate", query = "SELECT c FROM Calender c WHERE c.date = :date"),
    @NamedQuery(name = "Calender.findByStatus", query = "SELECT c FROM Calender c WHERE c.status = :status")})
public class Calender implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "calenderID")
    private Integer calenderID;
    @Basic(optional = false)
    @Column(name = "mDate")
    @Temporal(TemporalType.DATE)
    private Date mDate;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private User user;

    public Calender() {
    }

    public Calender(Integer calenderID) {
        this.calenderID = calenderID;
    }

    public Calender(Integer calenderID, Date mDate, Date date, String status) {
        this.calenderID = calenderID;
        this.mDate = mDate;
        this.date = date;
        this.status = status;
    }

    public Integer getCalenderID() {
        return calenderID;
    }

    public void setCalenderID(Integer calenderID) {
        this.calenderID = calenderID;
    }

    public Date getMDate() {
        return mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calenderID != null ? calenderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calender)) {
            return false;
        }
        Calender other = (Calender) object;
        if ((this.calenderID == null && other.calenderID != null) || (this.calenderID != null && !this.calenderID.equals(other.calenderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Calender[ calenderID=" + calenderID + " ]";
    }
    
}
