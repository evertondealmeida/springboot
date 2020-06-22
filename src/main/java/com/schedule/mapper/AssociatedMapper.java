package com.schedule.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.schedule.dto.AssociatedDTO;
import com.schedule.exception.BadRequestException;
import com.schedule.model.Associated;

public class AssociatedMapper {
	
	private AssociatedMapper() {
	}
	
	public static Associated fromDTO(AssociatedDTO dto) {
			
		final Associated associated = new Associated();
			
		if(dto.getName() == null || dto.getName().trim().isEmpty() ) throw new BadRequestException("O campo 'nome' é obrigatório e não pode ser vazio.");
		associated.setName(dto.getName());	
		
		if(dto.getCpf() != null){
			String cpf = dto.getCpf().trim().replaceAll("\\D", "");
			if(cpf.isEmpty() || cpf.length() != 11 ) throw new BadRequestException("O campo 'CPF' é obrigatório e deve conter 11 números.");
			else associated.setCpf(cpf);
		}else throw new BadRequestException("O campo 'CPF' é obrigatório e deve conter 11 números.");		
		return associated;		
	}
	
	 public static AssociatedDTO toDTO(Associated associated) {
		 if(associated == null) {
			 return null;
	     }

	     final AssociatedDTO dto = new AssociatedDTO();
	     dto.setId(associated.getId());
	     dto.setCpf(associated.getCpf());
	     dto.setName(associated.getName());
	     dto.setCreationDate(associated.getCreationDate().toString());  
	     return dto;
	 }
	 public static List<AssociatedDTO> toDTO(List<Associated> associateds) {
	        return associateds.stream().map(AssociatedMapper::toDTO).collect(Collectors.toList());
	    }
}
