package com.schedule.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.schedule.dto.ScheduleDTO;
import com.schedule.exception.BadRequestException;
import com.schedule.model.Schedule;

public class ScheduleMapper {
	
	private ScheduleMapper() {
	}
	
	public static Schedule fromDTO(ScheduleDTO dto) {
			
		final Schedule schedule = new Schedule();
			
		if(dto.getTitle() == null || dto.getTitle().trim().isEmpty() ) throw new BadRequestException("O campo 'titulo' é obrigatório e não pode ser vazio.");
		schedule.setTitle(dto.getTitle());	
		
		if(dto.getDescription() == null || dto.getDescription().trim().isEmpty()) throw new BadRequestException("O campo 'descrição' é obrigatório e não pode ser vazio.");
		schedule.setDescription(dto.getDescription());
		
			
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			if(dto.getStartSchedule() == null) {
				throw new BadRequestException("O campo 'data de início' é obrigatório.");
			} else { 
				LocalDateTime startSchedule = LocalDateTime.parse(dto.getStartSchedule(), formatter);
				schedule.setStartSchedule(startSchedule);
			}		
			if(dto.getEndSchedule() == null || dto.getEndSchedule().trim().isEmpty()) {
				schedule.setEndSchedule(schedule.getStartSchedule().plusMinutes(1));			
			} else { 
				LocalDateTime endSchedule = LocalDateTime.parse(dto.getEndSchedule(), formatter);
				schedule.setEndSchedule(endSchedule);				
			}
		}catch(DateTimeParseException e) {
			throw new BadRequestException("O campo 'data' deve estar no formato ( yyyy-MM-dd HH:mm:ss).");
		}			
		return schedule;		
	}
	
	 public static ScheduleDTO toDTO(Schedule schedule) {
		 if(schedule == null) {
			 return null;
	     }

	     final ScheduleDTO dto = new ScheduleDTO();
	     dto.setId(schedule.getId());
	     dto.setTitle(schedule.getTitle());
	     dto.setDescription(schedule.getDescription());
	     dto.setTotalVotes(schedule.getTotalVotes());
	     dto.setTotalApproved(schedule.getTotalApproved());
	     dto.setTotalReproved(schedule.getTotalReproved());
	     dto.setEndSchedule(schedule.getEndSchedule().toString());
	     dto.setStartSchedule(schedule.getStartSchedule().toString());   
	     return dto;
	 }
	 public static List<ScheduleDTO> toDTO(List<Schedule> schedules) {
	        return schedules.stream().map(ScheduleMapper::toDTO).collect(Collectors.toList());
	    }
}
