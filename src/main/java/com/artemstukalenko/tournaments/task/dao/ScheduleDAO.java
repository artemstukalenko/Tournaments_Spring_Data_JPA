package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.Schedule;

import java.sql.SQLException;
import java.util.List;

public interface ScheduleDAO {

    List<Schedule> getAllSchedules();

    Schedule findScheduleById(int scheduleId);

    boolean addOrUpdateSchedule(Schedule scheduleToAdd);

    boolean deleteScheduleById(int scheduleId);

    boolean deleteScheduleByExternalId(int teamId, String columnName);
}
