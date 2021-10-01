package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.UserRoleDAO;
import com.artemstukalenko.tournaments.task.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<UserRole> getAllUserRoles() {
        List<UserRole> allRoles;

        Session session = sessionFactory.getCurrentSession();
        allRoles = session.createQuery("from UserRole", UserRole.class).getResultList();

        return allRoles;
    }

    @Override
    public UserRole findRoleById(int roleId) throws SQLException {
        return null;
    }

    @Override
    public boolean addNewRole(UserRole roleToAdd) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteRoleById(int roleId) throws SQLException {
        return false;
    }

    @Override
    public boolean updateRoleInDB(int roleToUpdate, UserRole updatedRole) throws SQLException {
        return false;
    }

}
