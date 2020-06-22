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

import com.schedule.dto.AssociatedDTO;
import com.schedule.mapper.AssociatedMapper;
import com.schedule.service.AssociatedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/associated")
@Api(value="API REST Associados.")
@CrossOrigin(origins="*")
public final class AssociatedController {
		
	@Autowired
	private AssociatedService associatedService;
	
	@GetMapping(path = "")
	@ApiOperation(value="Retorna lista de associados.")
	public List<AssociatedDTO> get() {
		return AssociatedMapper.toDTO(associatedService.getAssociated());
	}
	
	@GetMapping(path = "/id/{id}")
	@ApiOperation(value="Retorna associado por id.")
	public AssociatedDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return AssociatedMapper.toDTO(associatedService.getById(id));
	}
	
	@PostMapping(path = "/save")
	@ApiOperation(value="Cria um associado.")
	public void create(@RequestBody AssociatedDTO associatedDTO) {
		associatedService.create(AssociatedMapper.fromDTO(associatedDTO));
	}
	
	@DeleteMapping(path= "/id/{id}")
	@ApiOperation(value="Deleta um associado por id.")
	public void delete(@PathVariable (name = "id", required = true) Long id){
		associatedService.deleteById(id);
	}
	
	@PutMapping(path= "/id/{id}")
	@ApiOperation(value="Atualiza um associado por id.")
	public void update(@RequestBody AssociatedDTO associatedDTO ,@PathVariable (name = "id", required = true) Long id){
		associatedService.update(AssociatedMapper.fromDTO(associatedDTO),id);
		
		
	}
}
