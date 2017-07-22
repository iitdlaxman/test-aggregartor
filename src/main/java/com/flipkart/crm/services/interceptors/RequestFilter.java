package com.flipkart.crm.services.interceptors;

import com.flipkart.crm.services.annotations.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


/**
 * Created by laxman.muttineni on 10/07/17.
 */
@Provider
@Secured
public class RequestFilter implements ContainerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);


    private void setUidForRequest(ContainerRequestContext containerRequest) {

        String transId = containerRequest.getHeaderString("X-Request-ID");
        //MDC.put("id", transId);
        logger.info("Request Id from client : " + transId);
        MultivaluedMap<String, String> requestHeaders = containerRequest.getHeaders();
        logger.info("Request headers : ");

        for(MultivaluedMap.Entry entry : requestHeaders.entrySet())
            logger.info(entry.getKey() + " : " + entry.getValue());

        String clientIp = "NOT_AVAILABLE";

        if (requestHeaders.containsKey("FK-CLIENT-IP")) {
            clientIp = requestHeaders.get("FK-CLIENT-IP").get(0);
            MDC.put("FK-CLIENT-IP", clientIp);

        }
        logger.info("Method : " + containerRequest.getMethod() + "  Request url :" + containerRequest.getRequest().toString() + " IP Address : " + clientIp);
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        setUidForRequest(requestContext);
    }
}
