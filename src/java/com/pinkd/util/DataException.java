/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pinkd.util;

/**
 *
 * @author aubreyM
 */
public class DataException extends Exception {

    public static final int DUPLICATE = 1;
    public static final int ILLEGAL_STATE = 2;
    public static final int UNKNOWN_ERROR = 3;
    public static final int DATA_NOT_FOUND = 4;
    int code;

    public DataException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
