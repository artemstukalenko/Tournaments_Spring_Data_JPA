package com.artemstukalenko.tournaments.task.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class EntityDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session session;

    protected void initializeSession() {
        this.session = sessionFactory.getCurrentSession();
    }

}
