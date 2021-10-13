package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.ScheduleRepository;
import com.artemstukalenko.tournaments.task.entity.Schedule;
import com.artemstukalenko.tournaments.task.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Schedule findScheduleById(int scheduleId) {
        Optional<Schedule> foundSchedule = scheduleRepository.findById(scheduleId);
        return Optional.ofNullable(foundSchedule).get().orElse(new Schedule());
    }

    @Override
    public boolean addOrUpdateSchedule(Schedule scheduleToAdd) {
        scheduleRepository.save(scheduleToAdd);
        return true;
    }

    @Override
    public boolean deleteScheduleById(int scheduleId) {
        scheduleRepository.getById(scheduleId);
        return true;
    }
}
