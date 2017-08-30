package com.flipkart.crm.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.eclipse.jetty.http.HttpStatus;

/**
 * Created by laxman.muttineni on 15/11/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    private static final String SUCCESS = "SUCCESS";

    private String traceId;

    private int statusCode;

    private String message;

    public BaseResponse() {
        statusCode = HttpStatus.OK_200;
        message = SUCCESS;
    }

    public BaseResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
