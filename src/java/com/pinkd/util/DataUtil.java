/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.util;

import com.pinkd.data.Admin;
import com.pinkd.data.Calender;
import com.pinkd.data.Campaign;
import com.pinkd.data.CancerType;
import com.pinkd.data.Event;
import com.pinkd.data.Exam;
import com.pinkd.data.Experience;
import com.pinkd.data.Game;
import com.pinkd.data.Myth;
import com.pinkd.data.QuestionAnswer;
import com.pinkd.data.Symptom;
import com.pinkd.data.Tutorial;
import com.pinkd.data.User;
import com.pinkd.dto.AdminDTO;
import com.pinkd.dto.CalenderDTO;
import com.pinkd.dto.CampaignDTO;
import com.pinkd.dto.CancerTypeDTO;
import com.pinkd.dto.EventDTO;
import com.pinkd.dto.ExamDTO;
import com.pinkd.dto.ExperienceDTO;
import com.pinkd.dto.GameDTO;
import com.pinkd.dto.MythDTO;
import com.pinkd.dto.QuestionAnswerDTO;
import com.pinkd.dto.ResponseDTO;
import com.pinkd.dto.SymptomDTO;
import com.pinkd.dto.TutorialDTO;
import com.pinkd.dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sipho
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {

    private static final Logger log = Logger.getLogger("DataUtil");

    @PersistenceContext
    private EntityManager em;

    public Admin getAdmin(int id) {
        return em.find(Admin.class, id);
    }

    public Calender getCalender(int id) {
        return em.find(Calender.class, id);
    }

    public Campaign getCampaign(int id) {
        return em.find(Campaign.class, id);
    }

    public CancerType getCancer(int id) {
        return em.find(CancerType.class, id);
    }

    public Event getEvent(int id) {
        return em.find(Event.class, id);
    }

    public Exam getExam(int id) {
        return em.find(Exam.class, id);
    }

    public Experience getExperience(int id) {
        return em.find(Experience.class, id);
    }

    public Game getGame(int id) {
        return em.find(Game.class, id);
    }

    public Myth getMyth(int id) {
        return em.find(Myth.class, id);
    }

    public QuestionAnswer getQuestionAndAnswer(int id) {
        return em.find(QuestionAnswer.class, id);
    }

    public Symptom getSymptom(int id) {
        return em.find(Symptom.class, id);
    }

    public Tutorial getTutorial(int id) {
        return em.find(Tutorial.class, id);
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    public ResponseDTO addAdmin(AdminDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Admin a = new Admin();
            a.setDate(new Date());
            a.setEmail(dto.getEmail());
            a.setGcmID(dto.getGcmID());
            a.setName(dto.getName());
            a.setPassword(dto.getPassword());
            a.setPhone(dto.getPhone());
            a.setStatus("Active");
            a.setSurname(dto.getSurname());
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Admin Added");
            resp.setAdmin(new AdminDTO(a));
            log.log(Level.INFO, "Added Admin {0}", a.getAdminID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Admin Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateAdmin(AdminDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Admin a = getAdmin(dto.getAdminID());
            a.setEmail(dto.getEmail());
            a.setGcmID(dto.getGcmID());
            a.setName(dto.getName());
            a.setPassword(dto.getPassword());
            a.setPhone(dto.getPhone());
            a.setStatus(dto.getStatus());
            a.setSurname(dto.getSurname());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Admin Updated");
            resp.setAdmin(new AdminDTO(a));
            log.log(Level.INFO, "Admin Updated {0}", a.getAdminID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Admin Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addCalender(CalenderDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Calender c = new Calender();
            c.setUser(getUser(dto.getUserID()));
            c.setDate(new Date());
            c.setMDate(new Date(dto.getmDate()));
            c.setStatus("Active");
            em.persist(c);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Calender Added");
            resp.setCalender(new CalenderDTO(c));
            log.log(Level.INFO, "Added Calender {0}", c.getCalenderID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Calender Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateCalender(CalenderDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Calender c = getCalender(dto.getCalenderID());
            c.setUser(getUser(dto.getUserID()));
            c.setMDate(new Date());
            c.setStatus(dto.getStatus());
            em.merge(c);
            resp.setStatusCode(0);
            resp.setMessage("Calender Updated");
            resp.setCalender(new CalenderDTO(c));
            log.log(Level.INFO, "Updated Calender {0}", c.getCalenderID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updated Calender Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addCampaign(CampaignDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Campaign c = new Campaign();
            c.setAdmin(getAdmin(dto.getAdminID()));
            c.setName(dto.getName());
            c.setContent(dto.getContent());
            c.setVenue(dto.getVenue());
            c.setLatitude(dto.getLatitude());
            c.setLongitude(dto.getLongitude());
            c.setCampaignDate(new Date(dto.getCampaignDate()));
            c.setDate(new Date());
            c.setStatus("Active");
            em.persist(c);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Campaign Added");
            resp.setCampaign(new CampaignDTO(c));
            log.log(Level.INFO, "Added Campaign {0}", c.getCampaingID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Campaign Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateCampaign(CampaignDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Campaign c = getCampaign(dto.getCampaignID());
            c.setAdmin(getAdmin(dto.getAdminID()));
            c.setName(dto.getName());
            c.setContent(dto.getContent());
            c.setVenue(dto.getVenue());
            c.setLatitude(dto.getLatitude());
            c.setLongitude(dto.getLongitude());
            c.setCampaignDate(new Date());
            c.setStatus(dto.getStatus());
            em.merge(c);
            resp.setStatusCode(0);
            resp.setMessage("Campaign Updated");
            resp.setCampaign(new CampaignDTO(c));
            log.log(Level.INFO, "Apdated Campaign {0}", c.getCampaingID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Campaign Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addCancerType(CancerTypeDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            CancerType c = new CancerType();
            c.setAdmin(getAdmin(dto.getAdminID()));
            c.setName(dto.getName());
            c.setDate(new Date());
            c.setStatus("Active");
            em.persist(c);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Cancer Type Added");
            resp.setCancer(new CancerTypeDTO(c));
            log.log(Level.INFO, "Added Cancer Type {0}", c.getCancerID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Cancer Type Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateCancerType(CancerTypeDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            CancerType c = getCancer(dto.getCancerID());
            c.setAdmin(getAdmin(dto.getAdminID()));
            c.setName(dto.getName());
            c.setStatus(dto.getStatus());
            em.merge(c);
            resp.setStatusCode(0);
            resp.setMessage("Cancer Type Updated");
            resp.setCancer(new CancerTypeDTO(c));
            log.log(Level.INFO, "Updated Cancer Type {0}", c.getCancerID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Cancer Type Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addEvent(EventDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Event a = new Event();
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setName(dto.getName());
            a.setDescription(dto.getDescription());
            a.setVenue(dto.getVenue());
            a.setLatitude(dto.getLatitude());
            a.setLongitude(dto.getLongitude());
            a.setEventDate(new Date(dto.getEventDate()));
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Event Added");
            resp.setEvent(new EventDTO(a));
            log.log(Level.INFO, "Added Event {0}", a.getEventID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Event Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateEvent(EventDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Event a = getEvent(dto.getEventID());
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setName(dto.getName());
            a.setDescription(dto.getDescription());
            a.setVenue(dto.getVenue());
            a.setLatitude(dto.getLatitude());
            a.setLongitude(dto.getLongitude());
            a.setEventDate(new Date(dto.getEventDate()));
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Event Updated");
            resp.setEvent(new EventDTO(a));
            log.log(Level.INFO, "Updated Event {0}", a.getEventID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Event Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addExam(ExamDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Exam a = new Exam();
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setCancerType(getCancer(dto.getCancerID()));
            a.setStage(dto.getStage());
            a.setContent(dto.getContent());
            a.setNote(dto.getNote());
            a.setNoteContent(dto.getNoteContent());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Exam Added");
            resp.setExam(new ExamDTO(a));
            log.log(Level.INFO, "Added Exam {0}", a.getExamID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Exam Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateExam(ExamDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Exam a = getExam(dto.getExamID());
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setCancerType(getCancer(dto.getCancerID()));
            a.setStage(dto.getStage());
            a.setContent(dto.getContent());
            a.setNote(dto.getNote());
            a.setNoteContent(dto.getNoteContent());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Exam Updated");
            resp.setExam(new ExamDTO(a));
            log.log(Level.INFO, "Updated Exam {0}", a.getExamID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Exam Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addExperience(ExperienceDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Experience a = new Experience();
            a.setUser(getUser(dto.getUserID()));
            a.setStory(dto.getStory());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Experience Added");
            resp.setExperience(new ExperienceDTO(a));
            log.log(Level.INFO, "Added Experience {0}", a.getExperienceID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Experience Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateExperience(ExperienceDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Experience a = getExperience(dto.getExperienceID());
            a.setUser(getUser(dto.getUserID()));
            a.setStory(dto.getStory());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Experience Updated");
            resp.setExperience(new ExperienceDTO(a));
            log.log(Level.INFO, "Added Experience {0}", a.getExperienceID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Experience Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addGameQuestion(GameDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Game a = new Game();
            a.setQuestion(dto.getQuestion());
            a.setAnswerA(dto.getAnswerA());
            a.setAnswerB(dto.getAnswerB());
            a.setAnswerC(dto.getAnswerC());
            a.setAnswerD(dto.getAnswerD());
            a.setCorrect(dto.getCorrect());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Game Added");
            resp.setGame(new GameDTO(a));
            log.log(Level.INFO, "Added Game {0}", a.getGameID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Game Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateGameQuestion(GameDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Game a = getGame(dto.getGameID());
            a.setQuestion(dto.getQuestion());
            a.setAnswerA(dto.getAnswerA());
            a.setAnswerB(dto.getAnswerB());
            a.setAnswerC(dto.getAnswerC());
            a.setAnswerD(dto.getAnswerD());
            a.setCorrect(dto.getCorrect());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Game Updated");
            resp.setGame(new GameDTO(a));
            log.log(Level.INFO, "Updated Game {0}", a.getGameID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Experience Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addMyth(MythDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Myth a = new Myth();
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setContent(dto.getContent());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Myth Added");
            resp.setMyth(new MythDTO(a));
            log.log(Level.INFO, "Added Myth {0}", a.getMythID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Myth Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateMyth(MythDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Myth a = getMyth(dto.getMythID());
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setContent(dto.getContent());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Myth Updated");
            resp.setMyth(new MythDTO(a));
            log.log(Level.INFO, "Updated Myth {0}", a.getMythID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Myth Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addQuestionAnswer(QuestionAnswerDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            QuestionAnswer a = new QuestionAnswer();
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setUser(getUser(dto.getUserID()));
            a.setQuestion(dto.getQuestion());
            a.setAnswer("Pending");
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Question Added");
            resp.setQuestionAnswer(new QuestionAnswerDTO(a));
            log.log(Level.INFO, "Added Question {0}", a.getQuestionID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Question Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateQuestionAnswer(QuestionAnswerDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            QuestionAnswer a = getQuestionAndAnswer(dto.getQuestionID());
            if (dto.getAdminID() == 0) {
                a.setAdmin(getAdmin(1));
            } else {
                a.setAdmin(getAdmin(dto.getAdminID()));
            }
            a.setQuestion(dto.getQuestion());
            a.setAnswer(dto.getAnswer());
            a.setDate(new Date());
            a.setStatus(dto.getQuestion());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Question Updated");
            resp.setQuestionAnswer(new QuestionAnswerDTO(a));
            log.log(Level.INFO, "Updated Question {0}", a.getQuestionID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Question Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addSymptom(SymptomDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Symptom a = new Symptom();
            a.setCancerType(getCancer(dto.getCancerID()));
            a.setDescription(dto.getDescription());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Question Added");
            resp.setSymptom(new SymptomDTO(a));
            log.log(Level.INFO, "Added Symptom {0}", a.getSymptomID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Symptom Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateSymptom(SymptomDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Symptom a = getSymptom(dto.getSymptomID());
            a.setCancerType(getCancer(dto.getCancerID()));
            a.setDescription(dto.getDescription());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Question Updated");
            resp.setSymptom(new SymptomDTO(a));
            log.log(Level.INFO, "Updated Symptom {0}", a.getSymptomID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Symptom Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addTutorial(TutorialDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Tutorial a = new Tutorial();
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setHeading(dto.getHeading());
            a.setContent(dto.getContent());
            a.setImageURL("n/a");
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("Tutorial Added");
            resp.setTutorial(new TutorialDTO(a));
            log.log(Level.INFO, "Added Tutorial {0}", a.getTutorialID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding Tutorial Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateTutorial(TutorialDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Tutorial a = getTutorial(dto.getTutorialID());
            a.setAdmin(getAdmin(dto.getAdminID()));
            a.setHeading(dto.getHeading());
            a.setContent(dto.getContent());
            a.setImageURL(dto.getImageURL());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("Tutorial Updated");
            resp.setTutorial(new TutorialDTO(a));
            log.log(Level.INFO, "Updated Tutorial {0}", a.getTutorialID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating Tutorial Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO addUser(UserDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            User a = new User();
            a.setName(dto.getName());
            a.setPhone(dto.getPhone());
            a.setEmail(dto.getEmail());
            a.setPassword(dto.getPassword());
            a.setDate(new Date());
            a.setStatus("Active");
            em.persist(a);
            em.flush();
            resp.setStatusCode(0);
            resp.setMessage("User Added");
            resp.setUser(new UserDTO(a));
            log.log(Level.INFO, "Added User {0}", a.getUserID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Adding User Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateUser(UserDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            User a = getUser(dto.getUserID());
            a.setName(dto.getName());
            a.setPhone(dto.getPhone());
            a.setEmail(dto.getEmail());
            a.setPassword(dto.getPassword());
            a.setStatus(dto.getStatus());
            em.merge(a);
            resp.setStatusCode(0);
            resp.setMessage("User Updated");
            resp.setUser(new UserDTO(a));
            log.log(Level.INFO, "Updated User {0}", a.getUserID());
        } catch (Exception e) {
            log.log(Level.SEVERE, "****Error***** Updating User Class", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
            resp.setMessage("Unknown Error");
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO userLogin(UserDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("User.login", User.class);
            q.setParameter("username", dto.getEmail());
            q.setParameter("password", dto.getPassword());
            User a = (User) q.getSingleResult();
            if (a != null) {
                resp.setStatusCode(0);
                resp.setMessage("User logged in");
                resp.setUser(new UserDTO(a));
                log.log(Level.INFO, "Logged in User {0}", a.getUserID());
            } else {
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
                resp.setMessage("No records found");
                log.log(Level.SEVERE, "Login unsuccessful");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO adminLogin(AdminDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Admin.login", User.class);
            q.setParameter("email", dto.getEmail());
            q.setParameter("password", dto.getPassword());
            Admin a = (Admin) q.getSingleResult();
            if (a != null) {
                resp.setStatusCode(0);
                resp.setMessage("Admin logged in");
                resp.setAdmin(new AdminDTO(a));
                log.log(Level.INFO, "Logged in Admin {0}", a.getAdminID());
            } else {
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
                resp.setMessage("No records found");
                log.log(Level.SEVERE, "Login unsuccessful");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "ERROR", e);
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getGameQuestions() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query countQuery = em.createNativeQuery("select count(*) from Game");
            long count = (Long) countQuery.getSingleResult();
            Random random = new Random();
            int number = random.nextInt((int) count);

            Query q = em.createNamedQuery("Game.findByGameID", Game.class);
            q.setParameter("id", number);
            q.setFirstResult(number);
            q.setMaxResults(1);
            List<Game> list = q.getResultList();
            List<GameDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Game a : list) {
                    vList.add(new GameDTO(a));
                }
                resp.setMessage("Game Questions found: " + vList.size());
                resp.setStatusCode(0);
                resp.setGames(vList);
            } else {
                resp.setMessage("No Questions found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }
            log.log(Level.OFF, "Found game questions {0}: ", vList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    
    public ResponseDTO getMythsByRandom() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query countQuery = em.createNamedQuery("Myth.findAll", Myth.class);
            int count = countQuery.getMaxResults();
            Random random = new Random();
            int number = random.nextInt((int) count);

            Query q = em.createNamedQuery("Myth.findByMythID", Myth.class);
            q.setParameter("id", number);
            q.setFirstResult(number);
            q.setMaxResults(1);
            List<Myth> list = q.getResultList();
            List<MythDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Myth a : list) {
                    vList.add(new MythDTO(a));
                }
                resp.setMessage("Myths found: " + vList.size());
                resp.setStatusCode(0);
                resp.setMyths(vList);
            } else {
                resp.setMessage("No myths found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }
            log.log(Level.OFF, "Found myths {0}: ", vList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    
    public ResponseDTO getMyths() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Myth.findAll", Myth.class);
            List<Myth> list = q.getResultList();
            List<MythDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Myth a : list) {
                    vList.add(new MythDTO(a));
                }
                resp.setMessage("Myths found: " + vList.size());
                resp.setStatusCode(0);
                resp.setMyths(vList);
            } else {
                resp.setMessage("No myths found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }
            log.log(Level.OFF, "Found myths {0}: ", vList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    
    public ResponseDTO getTutorials() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Tutorial.findAll", Tutorial.class);
            List<Tutorial> list = q.getResultList();
            List<TutorialDTO> vList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (Tutorial a : list) {
                    vList.add(new TutorialDTO(a));
                }
                resp.setMessage("Tutorials found: " + vList.size());
                resp.setStatusCode(0);
                resp.setTutorials(vList);
            } else {
                resp.setMessage("No Tutorials found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }
            log.log(Level.OFF, "Found Tutorial {0}: ", vList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getPendingQuestions() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("QuestionAnswer.findByAnswer", QuestionAnswer.class);
            q.setParameter("answer", "Pending");
            //QuestionAnswer a = (QuestionAnswer) q.getSingleResult();
            List<QuestionAnswer> list = q.getResultList();
            List<QuestionAnswerDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (QuestionAnswer cr : list) {
                    gList.add(new QuestionAnswerDTO(cr));
                }
                resp.setMessage("Questions found: " + gList.size());
                resp.setStatusCode(0);
                resp.setQuestionAnswers(gList);
            } else {
                resp.setMessage("No Questions found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found questions {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
    
    public ResponseDTO getQuestionsAndAnswers() {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("QuestionAnswer.findAll", QuestionAnswer.class);
            q.setParameter("answer", "Pending");
            //QuestionAnswer a = (QuestionAnswer) q.getSingleResult();
            List<QuestionAnswer> list = q.getResultList();
            List<QuestionAnswerDTO> gList = new ArrayList<>();
            if (!list.isEmpty()) {
                for (QuestionAnswer cr : list) {
                    gList.add(new QuestionAnswerDTO(cr));
                }
                resp.setMessage("Questions found: " + gList.size());
                resp.setStatusCode(0);
                resp.setQuestionAnswers(gList);
            } else {
                resp.setMessage("No Questions found");
                resp.setStatusCode(DataException.DATA_NOT_FOUND);
            }

            log.log(Level.OFF, "Found questions {0}: ", gList.size());
        } catch (Exception e) {
            resp.setMessage("Error");
            resp.setStatusCode(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }
}
