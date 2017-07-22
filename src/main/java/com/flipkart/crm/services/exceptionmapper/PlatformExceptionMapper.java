package com.flipkart.crm.services.exceptionmapper;

import com.flipkart.crm.entity.exception.ExceptionResponse;
import com.flipkart.crm.entity.exception.PlatformException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class PlatformExceptionMapper implements ExceptionMapper<PlatformException> {

    public Response toResponse(PlatformException exception) {
        ExceptionResponse response = new ExceptionResponse(exception.getResponseCode(), "","", "");
        return Response.status(exception.getCode()).entity(response).build();
    }
}
