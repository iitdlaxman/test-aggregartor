package com.flipkart.crm.dao;

import com.flipkart.crm.core.util.Constants;
import com.flipkart.crm.entity.session.Session;
import com.flipkart.crm.entity.session.SessionStatus;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Optional;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class SessionDAO extends AbstractDAO<Session> {

    @Inject
    public SessionDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Session create(Session session) {
        return persist(session);
    }

    public Session update(Session session) {
        return persist(session);
    }

    public Optional<Session> findById(Integer id) {
        return Optional.ofNullable(get(id));
    }

    public Optional<Session> findActiveSessionByAccountId(String accountId) {
        return Optional.ofNullable((Session) currentSession().createCriteria(Session.class)
                .add(Restrictions.eq("accountId", accountId))
                .add(Restrictions.eq("status", "ACTIVE")).uniqueResult());
    }

    public Optional<Session> findByToken(String token) {
        return Optional.ofNullable((Session) currentSession().createCriteria(Session.class)
                .add(Restrictions.eq("token", token)).uniqueResult());
    }

    @SuppressWarnings("unchecked")
    public Optional<List<Session>> findByAccountId(String accountId) {
        return Optional.ofNullable((List<Session>) currentSession().createCriteria(Session.class)
                .add(Restrictions.eq("accountId", accountId)).list());
    }

    public void deActiveSession(String token) {
        Optional<Session> sessionOptional = findByToken(token); //todo : cleanup
        if(sessionOptional.isPresent()) {
            update(expireSession(sessionOptional.get()));
        }
    }

    public void deActiveSessions(String accountId) {
        Optional<List<Session>> sessionsOptional = findByAccountId(accountId); //todo : cleanup
        if(sessionsOptional.isPresent()) {
            List<Session> sessions = sessionsOptional.get();
            sessions.stream()
                    .map(this::expireSession)
                    .forEach(this::update);
        }
    }

    private Session expireSession(Session session) {
        session.setUpdatedTime(DateTime.now());
        session.setStatus(SessionStatus.DEACTIVE);
        return session;
    }

}
