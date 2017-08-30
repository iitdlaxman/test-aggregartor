package com.flipkart.crm.services.auth;

import com.flipkart.crm.dao.SessionDAO;
import com.flipkart.crm.entity.session.Session;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * Created by laxman.muttineni on 29/08/17.
 */
public class SessionAuthenticator implements Authenticator<String, Session> {

    private SessionDAO sessionDAO;

    @Inject
    public SessionAuthenticator(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }

    @Override
    public Optional<Session> authenticate(String token) throws AuthenticationException {
        if (!Strings.isNullOrEmpty(token)) {
            java.util.Optional<Session> sessionOptional = sessionDAO.findByToken(token);
            if(sessionOptional.isPresent()) {
                return Optional.of(sessionOptional.get());
            }
        }
        return Optional.absent();
    }
}
