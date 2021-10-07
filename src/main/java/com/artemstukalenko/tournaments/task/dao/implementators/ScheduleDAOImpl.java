package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.ScheduleDAO;
import com.artemstukalenko.tournaments.task.entity.Schedule;
import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ScheduleDAOImpl extends EntityDAO implements ScheduleDAO {

    @Override
    @Transactional
    public List<Schedule> getAllSchedules() {
        List<Schedule> allSchedules;

        initializeSession();
        allSchedules = session.createQuery("from Schedule", Schedule.class).getResultList();

        return allSchedules;
    }

    @Override
    @Transactional
    public Schedule findScheduleById(int scheduleId) {
        Schedule soughtSchedule;

        initializeSession();
        soughtSchedule = session.get(Schedule.class, scheduleId);

        return soughtSchedule;
    }

    @Override
    @Transactional
    public boolean addOrUpdateSchedule(Schedule scheduleToAdd) {

        initializeSession();
        session.saveOrUpdate(scheduleToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteScheduleById(int scheduleId) {

        initializeSession();
        Query<Schedule> queryForDeletingScheduleById = session
                .createQuery("delete from Schedule where scheduleId = :idToDelete");
        queryForDeletingScheduleById.setParameter("idToDelete", scheduleId);
        queryForDeletingScheduleById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public boolean deleteScheduleByExternalId(int externalId, String columnName) {

        String deletingQuery = "delete from schedules where " + columnName + " = :id";

        initializeSession();
        Query<TeamPlayer> queryForCustomDeletion = session.createNativeQuery(deletingQuery)
                .setParameter("id", externalId);
        queryForCustomDeletion.executeUpdate();

        return true;
    }
}
