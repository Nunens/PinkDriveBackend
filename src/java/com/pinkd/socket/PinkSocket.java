/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.socket;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.pinkd.dto.RequestDTO;
import com.pinkd.dto.ResponseDTO;
import com.pinkd.util.DataException;
import com.pinkd.util.TrafficCop;
import com.pinkd.util.Util;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Sipho
 */
@ServerEndpoint("/pinkd")
@Stateful
public class PinkSocket {

    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
    Gson gson = new Gson();
    private static final Logger log = Logger.getLogger("PinkSocket");
    long start = System.currentTimeMillis();
    RequestDTO dto;

    @EJB
    Util util;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        //Handle new connection here
        ResponseDTO resp = new ResponseDTO();
        resp.setSessionID(session.getId());
        resp.setStatusCode(0);
        resp.setMessage("Handshake successful");
        log.log(Level.INFO, "New Session Created: " + gson.toJson(resp));
        peers.add(session);
        session.getBasicRemote().sendText(gson.toJson(resp));
    }

    /**
     *
     * @param message
     * @throws Exception
     */
    @OnMessage
    public String onMessage(String message) throws Exception {
        //Handle client received message here
        log.log(Level.INFO, "New Message received: " + message);
        ResponseDTO resp = new ResponseDTO();
        try {
            dto = gson.fromJson(message, RequestDTO.class);
            log.log(Level.INFO, "REQUEST: {0}", gson.toJson(dto));
            log.log(Level.INFO, "###### ---> Starting AR Original Socket: requestType = {0}", dto.getRequestType());
            resp = TrafficCop.processRequest(dto, util);
            log.log(Level.INFO, "RESPONSE: {0}", gson.toJson(resp));
        } catch (DataException e) {
            resp.setStatusCode(ResponseDTO.SERVER_ERROR);
            resp.setMessage("Server Error");
            log.log(Level.SEVERE, "ERROR receiving request", e);
        } catch(JsonSyntaxException e){
            resp.setStatusCode(ResponseDTO.SERVER_ERROR);
            resp.setMessage("Json Syntax Error");
            log.log(Level.SEVERE, "Json Syntax Error", e);
        }finally {
            log.log(Level.OFF, resp.toString());
            //sendData(resp);
            long end = System.currentTimeMillis();
            log.log(Level.OFF, "---> AftaRobot Original Socket completed, elapsed seconds: {0}",
                    getElapsed(start, end));
        }
        return gson.toJson(resp);
    }

    private double getElapsed(long start, long end) {
        BigDecimal d = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return d.doubleValue();
    }

    @OnClose
    public void onClose(Session session,
            CloseReason reason) {
        //Handle closing connection here
        peers.remove(session);
    }

    @OnError
    public void onError(Session session,
            Throwable throwable) {
        //Handle error during transport here
    }

    public void sendData(ResponseDTO resp) throws IOException, Exception {
        for (Session session : peers) {
            //if (session.getId().equals(dto.getSessionID())) {
            log.log(Level.INFO, "The Socket response: " + gson.toJson(resp));
            session.getBasicRemote().sendText(gson.toJson(resp));
            //}
        }
    }

}
