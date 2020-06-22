package com.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VotingDTO {
	
	@JsonFormat
	private Long idSchedule;
	
	@JsonFormat
	private Long idAssociated;
	
	@JsonFormat
	private boolean vote;

	public Long getIdSchedule() {
		return idSchedule;
	}

	public void setIdSchedule(Long idSchedule) {
		this.idSchedule = idSchedule;
	}

	public Long getIdAssociated() {
		return idAssociated;
	}

	public void setIdAssociated(Long idAssociated) {
		this.idAssociated = idAssociated;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}
	
	
}
