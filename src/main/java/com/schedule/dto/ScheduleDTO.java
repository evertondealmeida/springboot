package com.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ScheduleDTO {
	
	@JsonFormat
	private Long id;
	
	@JsonFormat
	private String title;	
	
	@JsonFormat
	private String description;
	
	@JsonFormat
	private int totalVotes;
	
	@JsonFormat
	private int totalApproved;
	
	@JsonFormat
	private int totalReproved;
	
	@JsonFormat
	private String startSchedule;
	
	@JsonFormat
	private String endSchedule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	public int getTotalApproved() {
		return totalApproved;
	}

	public void setTotalApproved(int totalApproved) {
		this.totalApproved = totalApproved;
	}

	public int getTotalReproved() {
		return totalReproved;
	}

	public void setTotalReproved(int totalReproved) {
		this.totalReproved = totalReproved;
	}

	public String getStartSchedule() {
		return startSchedule;
	}

	public void setStartSchedule(String startSchedule) {
		this.startSchedule = startSchedule;
	}

	public String getEndSchedule() {
		return endSchedule;
	}

	public void setEndSchedule(String endSchedule) {
		this.endSchedule = endSchedule;
	}
	
	
}
