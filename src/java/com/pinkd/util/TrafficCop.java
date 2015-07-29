/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.util;

import com.google.gson.Gson;
import com.pinkd.dto.RequestDTO;
import com.pinkd.dto.ResponseDTO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sipho
 */
public class TrafficCop {

    private static final Logger log = Logger.getLogger("TrafficCop");

    public static ResponseDTO processRequest(RequestDTO dto, Util util) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Gson gson = new Gson();
        log.log(Level.INFO, dto.toString());
        log.log(Level.INFO, "###### ---> Starting AR Pilot main: requestType = {0}", dto.getRequestType());
        switch (dto.getRequestType()) {
            case RequestDTO.login:
                log.log(Level.OFF, gson.toJson(dto.getUserDTO()));
                resp = util.userLogin(dto.getUserDTO());
                break;
            //case RequestDTO.addAdmin:
            //    resp = util.addAdmin(dto.getAdminDTO());
            //    break;
            case RequestDTO.addCalender:
                resp = util.addCalender(dto.getCalenderDTO());
                break;
            case RequestDTO.addCampaign:
                resp = util.addCampaign(dto.getCampaignDTO());
                break;
            case RequestDTO.addCancer:
                resp = util.addCalender(dto.getCalenderDTO());
                break;
            case RequestDTO.addEvent:
                resp = util.addEvent(dto.getEventDTO());
                break;
            case RequestDTO.addExam:
                resp = util.addExam(dto.getExamDTO());
                break;
            case RequestDTO.addExperience:
                resp = util.addExperience(dto.getExperienceDTO());
                break;
            case RequestDTO.addGameQuestion:
                resp = util.addGameQuestion(dto.getGameDTO());
                break;
            case RequestDTO.addMyth:
                resp = util.addMyth(dto.getMythDTO());
                break;
            case RequestDTO.addQuestionAndAnswer:
                resp = util.addQuestionAnswer(dto.getQuestionAnswerDTO());
                break;
            case RequestDTO.addSymptom:
                resp = util.addSymptom(dto.getSymptomDTO());
                break;
            case RequestDTO.addTutorial:
                resp = util.addTutorial(dto.getTutorialDTO());
                break;
            case RequestDTO.register:
                resp = util.addUser(dto.getUserDTO());
                break;
            case RequestDTO.updateCalender:
                resp = util.updateCalender(dto.getCalenderDTO());
                break;
            case RequestDTO.updateCampaign:
                resp = util.updateCampaign(dto.getCampaignDTO());
                break;
            case RequestDTO.updateCancer:
                resp = util.updateCalender(dto.getCalenderDTO());
                break;
            case RequestDTO.updateEvent:
                resp = util.updateEvent(dto.getEventDTO());
                break;
            case RequestDTO.updateExam:
                resp = util.updateExam(dto.getExamDTO());
                break;
            case RequestDTO.updateExperience:
                resp = util.updateExperience(dto.getExperienceDTO());
                break;
            case RequestDTO.updateGameQuestion:
                resp = util.updateGameQuestion(dto.getGameDTO());
                break;
            case RequestDTO.updateMyth:
                resp = util.updateMyth(dto.getMythDTO());
                break;
            case RequestDTO.updateQuestionAndAnswer:
                resp = util.updateQuestionAnswer(dto.getQuestionAnswerDTO());
                break;
            case RequestDTO.updateSymptom:
                resp = util.updateSymptom(dto.getSymptomDTO());
                break;
            case RequestDTO.updateTutorial:
                resp = util.updateTutorial(dto.getTutorialDTO());
                break;
            case RequestDTO.adminLogin:
                resp = util.adminLogin(dto.getAdminDTO());
                break;
            case RequestDTO.getPendingQuestions:
                resp = util.getPendingQuestions();
                break;
            case RequestDTO.getRandomMyth:
                resp = util.getMythsByRandom();
                break;
            case RequestDTO.getMyth:
                resp = util.getMyths();
                break;
            case RequestDTO.getTutorial:
                resp = util.getTutorials();
                break;
            case RequestDTO.getGameQuestion:
                resp = util.getGame();
                break;
            case RequestDTO.getQuestionAndAnswer:
                resp = util.getQuestionsAndAnswers();
                break;
        }
        return resp;
    }
}
