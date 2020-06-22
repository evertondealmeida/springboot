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
@Table(name = "schedule")
public class Schedule implements Serializable{

	private static final long serialVersionUID = -839987786106807326L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String title;	
	
	@NotNull
	private String description;
	
	@NotNull
	@Column(name = "start_schedule")
	private LocalDateTime startSchedule;
	
	@NotNull
	@Column(name = "end_schedule")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endSchedule;
	
	@NotNull
	@Column(name = "total_votes")
	private int totalVotes;
	
	@NotNull
	@Column(name = "total_Approved")
	private int totalApproved;
	
	@NotNull
	@Column(name = "total_Reproved")
	private int totalReproved;
	
	@OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
	private List<Voting> voting;
	
	public Schedule() {
	}
	
	
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

	public LocalDateTime getStartSchedule() {
		return startSchedule;
	}
	public void setStartSchedule(LocalDateTime startSchedule) {
		this.startSchedule = startSchedule;
	}
	public LocalDateTime getEndSchedule() {
		return endSchedule;
	}
	public void setEndSchedule(LocalDateTime endSchedule) {
		this.endSchedule = endSchedule;
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


	@Override
	public String toString() {
		return "Schedule [id=" + id + ", title=" + title + ", description=" + description + ", startSchedule="
				+ startSchedule + ", endSchedule=" + endSchedule + ", totalVotes=" + totalVotes + ", totalApproved="
				+ totalApproved + ", totalReproved=" + totalReproved + "]";
	}
	
	
	
}
