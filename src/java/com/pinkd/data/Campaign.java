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
@Table(name = "campaign", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campaign.findAll", query = "SELECT c FROM Campaign c"),
    @NamedQuery(name = "Campaign.findByCampaingID", query = "SELECT c FROM Campaign c WHERE c.campaingID = :campaingID"),
    @NamedQuery(name = "Campaign.findByName", query = "SELECT c FROM Campaign c WHERE c.name = :name"),
    @NamedQuery(name = "Campaign.findByContent", query = "SELECT c FROM Campaign c WHERE c.content = :content"),
    @NamedQuery(name = "Campaign.findByVenue", query = "SELECT c FROM Campaign c WHERE c.venue = :venue"),
    @NamedQuery(name = "Campaign.findByLatitude", query = "SELECT c FROM Campaign c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Campaign.findByLongitude", query = "SELECT c FROM Campaign c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Campaign.findByCampaignDate", query = "SELECT c FROM Campaign c WHERE c.campaignDate = :campaignDate"),
    @NamedQuery(name = "Campaign.findByDate", query = "SELECT c FROM Campaign c WHERE c.date = :date"),
    @NamedQuery(name = "Campaign.findByStatus", query = "SELECT c FROM Campaign c WHERE c.status = :status")})
public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "campaingID")
    private Integer campaingID;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Column(name = "venue")
    private String venue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "campaignDate")
    @Temporal(TemporalType.DATE)
    private Date campaignDate;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne
    private Admin admin;

    public Campaign() {
    }

    public Campaign(Integer campaingID) {
        this.campaingID = campaingID;
    }

    public Integer getCampaingID() {
        return campaingID;
    }

    public void setCampaingID(Integer campaingID) {
        this.campaingID = campaingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getCampaignDate() {
        return campaignDate;
    }

    public void setCampaignDate(Date campaignDate) {
        this.campaignDate = campaignDate;
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
        hash += (campaingID != null ? campaingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaign)) {
            return false;
        }
        Campaign other = (Campaign) object;
        if ((this.campaingID == null && other.campaingID != null) || (this.campaingID != null && !this.campaingID.equals(other.campaingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Campaign[ campaingID=" + campaingID + " ]";
    }
    
}
