package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.utils.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRepository {

    public EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager("NAME_PERSISTENCE_UNIT");
    }
    public void closeEntityManager(EntityManager em) {
        HibernateUtil.closeEntityManager(em);
    }

    public User get(String id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User u = em.find(User.class, id);
        em.close();
        return u;
    }
}
