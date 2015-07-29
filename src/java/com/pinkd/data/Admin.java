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
@Table(name = "admin", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdminID", query = "SELECT a FROM Admin a WHERE a.adminID = :adminID"),
    @NamedQuery(name = "Admin.findByGcmID", query = "SELECT a FROM Admin a WHERE a.gcmID = :gcmID"),
    @NamedQuery(name = "Admin.findByName", query = "SELECT a FROM Admin a WHERE a.name = :name"),
    @NamedQuery(name = "Admin.findBySurname", query = "SELECT a FROM Admin a WHERE a.surname = :surname"),
    @NamedQuery(name = "Admin.findByPhone", query = "SELECT a FROM Admin a WHERE a.phone = :phone"),
    @NamedQuery(name = "Admin.findByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByDate", query = "SELECT a FROM Admin a WHERE a.date = :date"),
    @NamedQuery(name = "Admin.findByStatus", query = "SELECT a FROM Admin a WHERE a.status = :status")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adminID")
    private Integer adminID;
    @Basic(optional = false)
    @Column(name = "gcmID")
    private String gcmID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<Myth> mythList;
    @OneToMany(mappedBy = "admin")
    private List<CancerType> cancerTypeList;
    @OneToMany(mappedBy = "admin")
    private List<Event> eventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    private List<Tutorial> tutorialList;
    @OneToMany(mappedBy = "admin")
    private List<Campaign> campaignList;
    @OneToMany(mappedBy = "admin")
    private List<QuestionAnswer> questionAnswerList;
    @OneToMany(mappedBy = "admin")
    private List<Exam> examList;

    public Admin() {
    }

    public Admin(Integer adminID) {
        this.adminID = adminID;
    }

    public Admin(Integer adminID, String gcmID) {
        this.adminID = adminID;
        this.gcmID = gcmID;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getGcmID() {
        return gcmID;
    }

    public void setGcmID(String gcmID) {
        this.gcmID = gcmID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public List<Myth> getMythList() {
        return mythList;
    }

    public void setMythList(List<Myth> mythList) {
        this.mythList = mythList;
    }

    @XmlTransient
    public List<CancerType> getCancerTypeList() {
        return cancerTypeList;
    }

    public void setCancerTypeList(List<CancerType> cancerTypeList) {
        this.cancerTypeList = cancerTypeList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @XmlTransient
    public List<Tutorial> getTutorialList() {
        return tutorialList;
    }

    public void setTutorialList(List<Tutorial> tutorialList) {
        this.tutorialList = tutorialList;
    }

    @XmlTransient
    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    @XmlTransient
    public List<QuestionAnswer> getQuestionAnswerList() {
        return questionAnswerList;
    }

    public void setQuestionAnswerList(List<QuestionAnswer> questionAnswerList) {
        this.questionAnswerList = questionAnswerList;
    }

    @XmlTransient
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Admin[ adminID=" + adminID + " ]";
    }
    
}
