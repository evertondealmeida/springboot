package com.schedule.mapper;

import com.schedule.dto.VotingDTO;
import com.schedule.exception.BadRequestException;
import com.schedule.model.Voting;

public class VotingMapper {

	private VotingMapper() {
	}

	public static VotingDTO fromDTO(VotingDTO dto) {

		if (dto.getIdSchedule() == null)
			throw new BadRequestException("O campo 'pauta id' é obrigatório.");

		if (dto.getIdAssociated() == null)
			throw new BadRequestException("O campo 'associado id' é obrigatório.");

		return dto;
	}

}
