package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.ScheduleRepository;
import com.artemstukalenko.tournaments.task.entity.Schedule;
import com.artemstukalenko.tournaments.task.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findScheduleById(int scheduleId) {
        return scheduleRepository.getById(scheduleId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateSchedule(Schedule scheduleToAdd) {
        scheduleRepository.save(scheduleToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteScheduleById(int scheduleId) {
        scheduleRepository.getById(scheduleId);
        return true;
    }
}
