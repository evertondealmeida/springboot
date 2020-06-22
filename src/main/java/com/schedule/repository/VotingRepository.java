package com.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schedule.model.Voting;

public interface VotingRepository extends JpaRepository<Voting, Long> {

	@Query(value ="SELECT v.id FROM public.voting v WHERE v.id_schedule = :id_schedule AND v.id_associated = :id_associated", nativeQuery = true)
	Integer checkExistence(@Param("id_schedule") Long id_schedule,@Param("id_associated") Long id_associated);

}
