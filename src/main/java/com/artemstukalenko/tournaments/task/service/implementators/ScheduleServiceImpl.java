package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.ScheduleDAO;
import com.artemstukalenko.tournaments.task.entity.Schedule;
import com.artemstukalenko.tournaments.task.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleDAO.getAllSchedules();
    }

    @Override
    public Schedule findScheduleById(int scheduleId) {
        return scheduleDAO.findScheduleById(scheduleId);
    }

    @Override
    public boolean addOrUpdateSchedule(Schedule scheduleToAdd) {
        return scheduleDAO.addOrUpdateSchedule(scheduleToAdd);
    }

    @Override
    public boolean deleteScheduleById(int scheduleId) {
        return scheduleDAO.deleteScheduleById(scheduleId);
    }
}
