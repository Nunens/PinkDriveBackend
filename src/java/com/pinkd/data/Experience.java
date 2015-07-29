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
@Table(name = "experience", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e"),
    @NamedQuery(name = "Experience.findByExperienceID", query = "SELECT e FROM Experience e WHERE e.experienceID = :experienceID"),
    @NamedQuery(name = "Experience.findByStory", query = "SELECT e FROM Experience e WHERE e.story = :story"),
    @NamedQuery(name = "Experience.findByDate", query = "SELECT e FROM Experience e WHERE e.date = :date"),
    @NamedQuery(name = "Experience.findByStatus", query = "SELECT e FROM Experience e WHERE e.status = :status")})
public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "experienceID")
    private Integer experienceID;
    @Column(name = "story")
    private String story;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User user;

    public Experience() {
    }

    public Experience(Integer experienceID) {
        this.experienceID = experienceID;
    }

    public Integer getExperienceID() {
        return experienceID;
    }

    public void setExperienceID(Integer experienceID) {
        this.experienceID = experienceID;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
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
        hash += (experienceID != null ? experienceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.experienceID == null && other.experienceID != null) || (this.experienceID != null && !this.experienceID.equals(other.experienceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Experience[ experienceID=" + experienceID + " ]";
    }
    
}
