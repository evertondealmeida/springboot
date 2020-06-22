package com.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/schedule")
@Api(value="API REST Pautas.")
@CrossOrigin(origins="*")
public class ScheduleController {
		
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping(path = "")
	@ApiOperation(value="Retorna lista de pautas.")
	public List<ScheduleDTO> get() {
		return ScheduleMapper.toDTO(scheduleService.getSchedule());
	}
	
	@GetMapping(path = "/id/{id}")
	@ApiOperation(value="Retorna pauta por id.")
	public ScheduleDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return ScheduleMapper.toDTO(scheduleService.getById(id));
	}
	
	@GetMapping(path = "/open")
	@ApiOperation(value="Retorna lista de pautas ativas.")
	public List<ScheduleDTO> getOpen() {
		return ScheduleMapper.toDTO(scheduleService.getScheduleOpen());
	}
	@GetMapping(path = "/closed")
	@ApiOperation(value="Retorna lista de pautas fechadas.")
	public List<ScheduleDTO> getClosed() {
		return ScheduleMapper.toDTO(scheduleService.getScheduleClosed());
	}
	@GetMapping(path = "/open/id/{id}")
	@ApiOperation(value="Retorna pauta ativa por id.")
	public ScheduleDTO getOpenByOpen(@PathVariable(name = "id", required = true) Long id) {
		return ScheduleMapper.toDTO(scheduleService.getOpenById(id));
	}
	
	@PostMapping(path = "/save")
	@ApiOperation(value="Cria uma nova pauta.")
	public void create(@RequestBody ScheduleDTO scheduleDTO){
		scheduleService.create(ScheduleMapper.fromDTO(scheduleDTO));
	}
	
	@DeleteMapping(path= "/id/{id}")
	@ApiOperation(value="Deleta uma pauta por id.")
	public void delete(@PathVariable (name = "id", required = true) Long id){
		scheduleService.deleteById(id);
	}
	
	@PutMapping(path= "/id/{id}")
	@ApiOperation(value="Atualiza uma pauta por id.")
	public void update(@RequestBody ScheduleDTO scheduleDTO ,@PathVariable (name = "id", required = true) Long id){
		scheduleService.update(ScheduleMapper.fromDTO(scheduleDTO),id);				
	}
	
	
}
