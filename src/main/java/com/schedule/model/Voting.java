package com.schedule.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name = "voting")
public class Voting implements Serializable{

	private static final long serialVersionUID = -8372868532657850529L;
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@ManyToOne
	@JoinColumn(name="id_schedule")
	private Schedule schedule;
	
	@ManyToOne
	@JoinColumn(name="id_associated")
	private Associated associated;
	
	@NotNull
	private boolean vote;
	
	@NotNull
	@Column(name = "date_voting")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateVoting;
	
	public Voting() {
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Associated getAssociated() {
		return associated;
	}

	public void setAssociated(Associated associated) {
		this.associated = associated;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public LocalDateTime getDateVoting() {
		return dateVoting;
	}

	public void setDateVoting(LocalDateTime dateVoting) {
		this.dateVoting = dateVoting;
	}
	
	
	
	
}
