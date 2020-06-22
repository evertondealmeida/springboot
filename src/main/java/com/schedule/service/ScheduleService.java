package com.schedule.service;

import java.util.List;
import java.util.Optional;

//import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.exception.*;
import com.schedule.model.Schedule;
import com.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {
	
	//private static final Logger LOG = Logger.getLogger(ScheduleService.class);
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public void create(Schedule schedule) {
		if(!schedule.getStartSchedule().isBefore(schedule.getEndSchedule())) throw new BadRequestException("A data de inicío não pode ser menor ou igual a data de fim.");
		scheduleRepository.saveAndFlush(schedule);
		
	}
	
	public List<Schedule>getSchedule(){
		return scheduleRepository.findAll();		
	}
	public List<Schedule> getScheduleOpen() {
		return scheduleRepository.findScheduleByOpen();
	}

	public List<Schedule> getScheduleClosed() {
		return scheduleRepository.findScheduleByClosed();
	}
	public Schedule getOpenById(Long id) throws NotFoundException {
		
		Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleOpenById(id);
		Schedule schedule = null;
		if(!optionalSchedule.isPresent()) {
			throw new NotFoundException("Essa pauta já encontra-se fechada ou não existe.");
		}else {
			schedule = optionalSchedule.get();
		}
		return schedule;
	}
	
	public Schedule getById(Long id) throws NotFoundException {
		Optional<Schedule> optionalSchedule = getByIdOptional(id);
		
		Schedule schedule = null;
		if(!optionalSchedule.isPresent()) {
			throw new NotFoundException("Pauta não encontrada para o ID: "+id);
		}else {
			schedule = optionalSchedule.get();
		}
		return schedule;
	}
	
	public void deleteById(Long id) throws NotFoundException {
		Optional<Schedule> optionalSchedule = getByIdOptional(id);
		if(!optionalSchedule.isPresent()) {
			throw new NotFoundException("Pauta não encontrada para o ID: "+id);
		}else {
			scheduleRepository.delete(optionalSchedule.get());
		}			
	}
	
	private Optional<Schedule> getByIdOptional(Long id){
		Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
		return optionalSchedule;
	}

	public void update(Schedule newSchedule,Long id) {
		Schedule scheduleOld = new Schedule();
		scheduleOld = getById(id);
		newSchedule.setId(scheduleOld.getId());
		scheduleRepository.save(newSchedule);
	}
	
	public void updateVoting(Schedule schedule) {
		scheduleRepository.save(schedule);
		
	}

	
	
	
}
