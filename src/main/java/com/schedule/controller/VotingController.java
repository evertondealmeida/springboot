package com.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.dto.VotingDTO;
import com.schedule.mapper.VotingMapper;
import com.schedule.service.VotingService;


@RestController
@RequestMapping(value = "/api/voting")
public class VotingController {
	
	@Autowired
	private VotingService votingService;
	
	@PostMapping(path = "")
    public void voting(@RequestBody VotingDTO votingDTO) {
		votingService.voting(VotingMapper.fromDTO(votingDTO));
    }
	
}
