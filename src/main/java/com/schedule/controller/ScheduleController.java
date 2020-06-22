package com.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.dto.ScheduleDTO;
import com.schedule.mapper.ScheduleMapper;
import com.schedule.service.ScheduleService;

@RestController
@RequestMapping(value = "/api/schedule")
public class ScheduleController {
		
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping(path = "")
	public List<ScheduleDTO> get() {
		return ScheduleMapper.toDTO(scheduleService.getSchedule());
	}
	
	@GetMapping(path = "/id/{id}")
	public ScheduleDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return ScheduleMapper.toDTO(scheduleService.getById(id));
	}
	
	@GetMapping(path = "/open")
	public List<ScheduleDTO> getOpen() {
		return ScheduleMapper.toDTO(scheduleService.getScheduleOpen());
	}
	@GetMapping(path = "/closed")
	public List<ScheduleDTO> getClosed() {
		return ScheduleMapper.toDTO(scheduleService.getScheduleClosed());
	}
	@GetMapping(path = "/open/id/{id}")
	public ScheduleDTO getOpenByOpen(@PathVariable(name = "id", required = true) Long id) {
		return ScheduleMapper.toDTO(scheduleService.getOpenById(id));
	}
	
	@PostMapping(path = "/save")
	public void create(@RequestBody ScheduleDTO scheduleDTO){
		scheduleService.create(ScheduleMapper.fromDTO(scheduleDTO));
	}
	
	@DeleteMapping(path= "/id/{id}")
	public void delete(@PathVariable (name = "id", required = true) Long id){
		scheduleService.deleteById(id);
	}
	
	@PutMapping(path= "/id/{id}")
	public void update(@RequestBody ScheduleDTO scheduleDTO ,@PathVariable (name = "id", required = true) Long id){
		scheduleService.update(ScheduleMapper.fromDTO(scheduleDTO),id);				
	}
	
	
}
