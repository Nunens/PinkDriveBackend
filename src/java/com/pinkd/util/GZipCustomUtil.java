/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.util;

import com.google.gson.Gson;
import com.pinkd.dto.ResponseDTO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Sipho
 */
public class GZipCustomUtil {

    static final Gson gson = new Gson();
    static final int ZIP_THRESHOLD = 512;
    private static final Logger log = Logger.getLogger(GZipCustomUtil.class.getName());

    public static ByteBuffer getZippedResponse(ResponseDTO resp) throws IOException {
        String json = gson.toJson(resp);
        byte[] bytes = null;
        if (json.length() < ZIP_THRESHOLD) {
            bytes = json.getBytes();
        } else {
            bytes = getZippedBytes(json);
        }
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        return buf;
    }

    private static byte[] getZippedBytes(String json)
            throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream zos = new GZIPOutputStream(byteArrayOutputStream);
        zos.write(json.getBytes());
        IOUtils.closeQuietly(zos);

        byte[] bytes = byteArrayOutputStream.toByteArray();

        return bytes;

    }
}
