package com.schedule.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.dto.VotingDTO;
import com.schedule.exception.BadRequestException;
import com.schedule.model.Associated;
import com.schedule.model.Schedule;
import com.schedule.model.Voting;
import com.schedule.repository.VotingRepository;

@Service
public class VotingService {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private AssociatedService associatedService;
	
	@Autowired
	private VotingRepository votingRepository;
	
	public void voting(VotingDTO votingDTO) {
		
	Schedule schedule = null;
	Associated associated = null;
	Voting voting = new Voting();
	schedule = scheduleService.getOpenById(votingDTO.getIdSchedule());	
	associated = associatedService.getById(votingDTO.getIdAssociated());
	if(votingRepository.checkExistence(votingDTO.getIdSchedule(),votingDTO.getIdAssociated()) != null) { 
	   throw new BadRequestException("Esse associado já votou.");
	}
	voting.setSchedule(schedule);
	voting.setAssociated(associated);
	voting.setDateVoting(LocalDateTime.now());
	voting.setVote(votingDTO.isVote());
	
	schedule.setTotalVotes(schedule.getTotalVotes()+1);
	if(voting.isVote()) schedule.setTotalApproved(schedule.getTotalApproved()+1);
	else schedule.setTotalReproved(schedule.getTotalReproved()+1);
	votingRepository.saveAndFlush(voting);
	scheduleService.updateVoting(schedule);
		
	}
	
}
