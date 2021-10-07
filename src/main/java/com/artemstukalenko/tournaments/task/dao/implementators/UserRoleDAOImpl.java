package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.UserRoleDAO;
import com.artemstukalenko.tournaments.task.entity.UserRole;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRoleDAOImpl extends EntityDAO implements UserRoleDAO {

    @Override
    @Transactional
    public List<UserRole> getAllUserRoles() {
        List<UserRole> allRoles;

        initializeSession();
        allRoles = session.createQuery("from UserRole", UserRole.class).getResultList();

        return allRoles;
    }

    @Override
    @Transactional
    public UserRole findRoleById(int roleId) {
        UserRole soughtRole;

        initializeSession();
        soughtRole = session.get(UserRole.class, roleId);


        return soughtRole;
    }

    @Override
    @Transactional
    public boolean addOrUpdateRole(UserRole roleToAdd) {

        initializeSession();
        session.saveOrUpdate(roleToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteRoleById(int roleId) {

        initializeSession();
        Query<UserRole> queryForDeletingUserRole = session.createQuery("delete from UserRole " +
                "where roleId = :idToDelete");
        queryForDeletingUserRole.setParameter("idToDelete", roleId);
        queryForDeletingUserRole.executeUpdate();

        return true;
    }
}
