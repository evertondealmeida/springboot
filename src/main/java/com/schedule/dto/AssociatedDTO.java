package com.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssociatedDTO {
	
	@JsonFormat
	public Long id;

	@JsonFormat
	public String cpf;
	
	@JsonFormat
	public String name;
	
	@JsonFormat
	public String creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
