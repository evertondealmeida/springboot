package com.schedule.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.exception.*;
import com.schedule.model.Associated;
import com.schedule.repository.AssociatedRepository;

@Service
public class AssociatedService {
	
	
	@Autowired
	private AssociatedRepository associatedRepository;
	
	public void create(Associated associated) {
		try {
			associated.setCreationDate(LocalDateTime.now());
			associatedRepository.saveAndFlush(associated);
		}catch(Exception e) {
			throw new BadRequestException("Esse CPF já consta na base de dados.");
		}
		
	}
	
	public List<Associated>getAssociated(){
		return associatedRepository.findAll();		
	}
	
	public Associated getById(Long id) throws NotFoundException {
		Optional<Associated> optionalAssociated = getByIdOptional(id);
		Associated associated = null;
		if(!optionalAssociated.isPresent()) {
			throw new NotFoundException("Associado não encontrado para o ID: "+id);
		}else {
			associated = optionalAssociated.get();
		}
		return associated;
	}
	
	public void deleteById(Long id) throws NotFoundException {
		Optional<Associated> optionalAssociated = getByIdOptional(id);
		if(!optionalAssociated.isPresent()) {
			throw new NotFoundException("Associado não encontrado para o ID: "+id);
		}else {
			associatedRepository.delete(optionalAssociated.get());
		}			
	}
	
	private Optional<Associated> getByIdOptional(Long id){
		Optional<Associated> optionalAssociated = associatedRepository.findById(id);
		return optionalAssociated;
	}

	public void update(Associated newAssociated,Long id) {
		Associated associatedOld = new Associated();
		associatedOld = getById(id);
		newAssociated.setId(associatedOld.getId());
		newAssociated.setCreationDate(associatedOld.getCreationDate());
		associatedRepository.save(newAssociated);
	}
}
