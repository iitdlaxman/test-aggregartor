package com.flipkart.crm.entity.exception;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class PlatformException extends Exception {

    private String executionId;

    private ResponseCode responseCode;

    private int code;

    private static final Logger logger = LoggerFactory.getLogger(PlatformException.class);

    public PlatformException(ResponseCode responseCode) {
        this(HttpStatus.INTERNAL_SERVER_ERROR_500, responseCode, responseCode.name());
    }

    public PlatformException(ResponseCode responseCode,
                             Throwable throwable) {
        this(HttpStatus.INTERNAL_SERVER_ERROR_500, responseCode, responseCode.name(), throwable);
    }

    public PlatformException(int code,
                             ResponseCode responseCode) {
        this(code, responseCode, responseCode.name());
    }

    public PlatformException(int code,
                             ResponseCode responseCode,
                             Throwable throwable) {
        this(code, responseCode, responseCode.name(), throwable);
    }

    public PlatformException(int code,
                             ResponseCode responseCode,
                             String message,
                             Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.responseCode = responseCode;
        this.executionId = "";//context.getExecutionId();
    }

    public PlatformException(int code,
                             ResponseCode responseCode,
                             String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.executionId = "";//context.getExecutionId();
    }

    public static PlatformException createFromReflectiveOperationException(int code,
                                                                            ReflectiveOperationException e) {
        Map<String, Object> returnMsg = new HashMap<String, Object>();
        returnMsg.put("Status code", code);
        returnMsg.put("Message", e.getCause().getMessage());
        StackTraceElement[] stackTraceElements = e.getCause().getStackTrace();
        List<StackTraceElement> stackTraceElementList = Arrays.asList(stackTraceElements);
        returnMsg.put("Cause Stack", stackTraceElementList.subList(0, stackTraceElementList.size() > 5 ? 5 : stackTraceElementList.size()));
        logger.info("Exception Dump and Cause Stack" + returnMsg.toString());
        logger.error(e.getCause().getMessage(), e.getMessage(), e.getCause());
        return new PlatformException(code, ResponseCode.INTERNAL_SERVER_ERROR, e.getCause().getMessage(), e);
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static Logger getLogger() {
        return logger;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
