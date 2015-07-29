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
@Table(name = "game", catalog = "pinkd", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findByGameID", query = "SELECT g FROM Game g WHERE g.gameID = :gameID"),
    @NamedQuery(name = "Game.findByQuestion", query = "SELECT g FROM Game g WHERE g.question = :question"),
    @NamedQuery(name = "Game.findByAnswerA", query = "SELECT g FROM Game g WHERE g.answerA = :answerA"),
    @NamedQuery(name = "Game.findByAnswerB", query = "SELECT g FROM Game g WHERE g.answerB = :answerB"),
    @NamedQuery(name = "Game.findByAnswerC", query = "SELECT g FROM Game g WHERE g.answerC = :answerC"),
    @NamedQuery(name = "Game.findByAnswerD", query = "SELECT g FROM Game g WHERE g.answerD = :answerD"),
    @NamedQuery(name = "Game.findByCorrect", query = "SELECT g FROM Game g WHERE g.correct = :correct"),
    @NamedQuery(name = "Game.findByDate", query = "SELECT g FROM Game g WHERE g.date = :date"),
    @NamedQuery(name = "Game.findByStatus", query = "SELECT g FROM Game g WHERE g.status = :status")})
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gameID")
    private Integer gameID;
    @Column(name = "question")
    private String question;
    @Column(name = "answerA")
    private String answerA;
    @Column(name = "answerB")
    private String answerB;
    @Basic(optional = false)
    @Column(name = "answerC")
    private String answerC;
    @Basic(optional = false)
    @Column(name = "answerD")
    private String answerD;
    @Basic(optional = false)
    @Column(name = "correct")
    private String correct;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Game() {
    }

    public Game(Integer gameID) {
        this.gameID = gameID;
    }

    public Game(Integer gameID, String answerC, String answerD, String correct, Date date, String status) {
        this.gameID = gameID;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correct = correct;
        this.date = date;
        this.status = status;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameID != null ? gameID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.gameID == null && other.gameID != null) || (this.gameID != null && !this.gameID.equals(other.gameID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pinkd.data.Game[ gameID=" + gameID + " ]";
    }
    
}
