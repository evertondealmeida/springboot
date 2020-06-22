package com.schedule.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "associated")
public class Associated implements Serializable {

	private static final long serialVersionUID = -4584658681477404532L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@NotNull
	public String cpf;
	
	@NotNull
	public String name;
	
	@NotNull
	@Column(name = "creation_date")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public LocalDateTime creationDate;
	
	@OneToMany(mappedBy = "associated", fetch = FetchType.LAZY)
	private List<Voting> voting;

	public Associated() {
	}
	
	
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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public String toString() {
		return "AssociatedDTO [id=" + id + ", cpf=" + cpf + ", name=" + name + ", creationDate=" + creationDate + "]";
	}
	
	

}
