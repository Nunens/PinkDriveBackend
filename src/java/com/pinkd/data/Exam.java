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
@Table(name = "exam", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findByExamID", query = "SELECT e FROM Exam e WHERE e.examID = :examID"),
    @NamedQuery(name = "Exam.findByStage", query = "SELECT e FROM Exam e WHERE e.stage = :stage"),
    @NamedQuery(name = "Exam.findByContent", query = "SELECT e FROM Exam e WHERE e.content = :content"),
    @NamedQuery(name = "Exam.findByNote", query = "SELECT e FROM Exam e WHERE e.note = :note"),
    @NamedQuery(name = "Exam.findByNoteContent", query = "SELECT e FROM Exam e WHERE e.noteContent = :noteContent"),
    @NamedQuery(name = "Exam.findByDate", query = "SELECT e FROM Exam e WHERE e.date = :date"),
    @NamedQuery(name = "Exam.findByStatus", query = "SELECT e FROM Exam e WHERE e.status = :status")})
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examID")
    private Integer examID;
    @Column(name = "stage")
    private String stage;
    @Column(name = "content")
    private String content;
    @Column(name = "note")
    private String note;
    @Column(name = "noteContent")
    private String noteContent;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "cancerID", referencedColumnName = "cancerID")
    @ManyToOne(optional = false)
    private CancerType cancerType;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne
    private Admin admin;

    public Exam() {
    }

    public Exam(Integer examID) {
        this.examID = examID;
    }

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examID != null ? examID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.examID == null && other.examID != null) || (this.examID != null && !this.examID.equals(other.examID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Exam[ examID=" + examID + " ]";
    }
    
}
