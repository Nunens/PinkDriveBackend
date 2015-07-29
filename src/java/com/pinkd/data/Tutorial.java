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
@Table(name = "tutorial", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutorial.findAll", query = "SELECT t FROM Tutorial t"),
    @NamedQuery(name = "Tutorial.findByTutorialID", query = "SELECT t FROM Tutorial t WHERE t.tutorialID = :tutorialID"),
    @NamedQuery(name = "Tutorial.findByHeading", query = "SELECT t FROM Tutorial t WHERE t.heading = :heading"),
    @NamedQuery(name = "Tutorial.findByContent", query = "SELECT t FROM Tutorial t WHERE t.content = :content"),
    @NamedQuery(name = "Tutorial.findByImageURL", query = "SELECT t FROM Tutorial t WHERE t.imageURL = :imageURL"),
    @NamedQuery(name = "Tutorial.findByDate", query = "SELECT t FROM Tutorial t WHERE t.date = :date"),
    @NamedQuery(name = "Tutorial.findByStatus", query = "SELECT t FROM Tutorial t WHERE t.status = :status")})
public class Tutorial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tutorialID")
    private Integer tutorialID;
    @Column(name = "heading")
    private String heading;
    @Column(name = "content")
    private String content;
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne(optional = false)
    private Admin admin;

    public Tutorial() {
    }

    public Tutorial(Integer tutorialID) {
        this.tutorialID = tutorialID;
    }

    public Integer getTutorialID() {
        return tutorialID;
    }

    public void setTutorialID(Integer tutorialID) {
        this.tutorialID = tutorialID;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
        hash += (tutorialID != null ? tutorialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutorial)) {
            return false;
        }
        Tutorial other = (Tutorial) object;
        if ((this.tutorialID == null && other.tutorialID != null) || (this.tutorialID != null && !this.tutorialID.equals(other.tutorialID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Tutorial[ tutorialID=" + tutorialID + " ]";
    }
    
}
