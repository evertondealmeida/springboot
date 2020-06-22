package com.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.dto.VotingDTO;
import com.schedule.mapper.VotingMapper;
import com.schedule.service.VotingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/api/voting")
@Api(value="API REST Votação.")
@CrossOrigin(origins="*")
public class VotingController {
	
	@Autowired
	private VotingService votingService;
	
	@PostMapping(path = "")
	@ApiOperation(value="Vota em uma pauta.")
    public void voting(@RequestBody VotingDTO votingDTO) {
		votingService.voting(VotingMapper.fromDTO(votingDTO));
    }
	
}
