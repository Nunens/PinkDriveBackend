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
@Table(name = "question_answer", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionAnswer.findAll", query = "SELECT q FROM QuestionAnswer q"),
    @NamedQuery(name = "QuestionAnswer.findByQuestionID", query = "SELECT q FROM QuestionAnswer q WHERE q.questionID = :questionID"),
    @NamedQuery(name = "QuestionAnswer.findByQuestion", query = "SELECT q FROM QuestionAnswer q WHERE q.question = :question"),
    @NamedQuery(name = "QuestionAnswer.findByAnswer", query = "SELECT q FROM QuestionAnswer q WHERE q.answer = :answer"),
    @NamedQuery(name = "QuestionAnswer.findByDate", query = "SELECT q FROM QuestionAnswer q WHERE q.date = :date"),
    @NamedQuery(name = "QuestionAnswer.findByStatus", query = "SELECT q FROM QuestionAnswer q WHERE q.status = :status")})
public class QuestionAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionID")
    private Integer questionID;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "adminID", referencedColumnName = "adminID")
    @ManyToOne
    private Admin admin;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private User user;

    public QuestionAnswer() {
    }

    public QuestionAnswer(Integer questionID) {
        this.questionID = questionID;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionID != null ? questionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionAnswer)) {
            return false;
        }
        QuestionAnswer other = (QuestionAnswer) object;
        if ((this.questionID == null && other.questionID != null) || (this.questionID != null && !this.questionID.equals(other.questionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.QuestionAnswer[ questionID=" + questionID + " ]";
    }
    
}
