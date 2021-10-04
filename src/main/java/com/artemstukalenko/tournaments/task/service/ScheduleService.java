package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAllSchedules();

    Schedule findScheduleById(int scheduleId);

    boolean addOrUpdateSchedule(Schedule scheduleToAdd);

    boolean deleteScheduleById(int scheduleId);

}
