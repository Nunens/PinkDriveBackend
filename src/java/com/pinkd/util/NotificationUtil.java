/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.util;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;
import com.pinkd.dto.AdminDTO;
import com.pinkd.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sipho
 */
public class NotificationUtil {

    static Sender sender = new Sender("AIzaSyBpnj0_9v7wzAigzA-ZjqbCcOCgcTFl-4I");
    static Message message;
    static MulticastResult results;
    static List<String> devices;
    private static final Logger logger = Logger.getLogger(NotificationUtil.class.getName());

    public NotificationUtil() {
    }

    public static void pushMessageToAdmin(String id, String name, String msg, List<AdminDTO> admins) {
        try {
            message = new Message.Builder()
                    .addData("message", msg)
                    .addData("header", name)
                    .collapseKey("message")
                    .delayWhileIdle(true)
                    .timeToLive(3)
                    .build();
            if (!admins.isEmpty()) {
                devices = new ArrayList<String>();
                for (AdminDTO dto : admins) {
                    if (!id.equals(dto.getGcmID())) {
                        devices.add(dto.getGcmID());
                    }
                }
                results = sender.send(message, devices, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.log(Level.OFF, "Admin msg results: " + results);
    }

    public static void pushMessageToUser(String id, String msg, String name, List<UserDTO> users) {
        try {
            message = new Message.Builder()
                    .addData("message", msg)
                    .addData("header", name)
                    .collapseKey("message")
                    .delayWhileIdle(true)
                    .timeToLive(3)
                    .build();
            if (!users.isEmpty()) {
                devices = new ArrayList<String>();
                for (UserDTO dto : users) {
                    //if (!id.equals(dto.getGcmID())) {
                    //    devices.add(dto.getGcmID());
                    //}
                }
                results = sender.send(message, devices, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.log(Level.OFF, "User msg results: " + results);
    }
}
