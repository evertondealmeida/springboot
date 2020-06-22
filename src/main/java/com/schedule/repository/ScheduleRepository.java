package com.schedule.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schedule.model.Schedule;
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	
	@Query(value ="SELECT s.id, s.title, s.description, s.start_schedule, s.total_approved, s.total_reproved, s.total_votes, s.end_schedule FROM public.schedule s WHERE s.start_schedule < current_timestamp AND s.end_schedule > current_timestamp", nativeQuery = true)
    List<Schedule> findScheduleByOpen();
	
	@Query(value ="SELECT s.id, s.title, s.description, s.start_schedule, s.total_approved, s.total_reproved, s.total_votes, s.end_schedule FROM public.schedule s WHERE s.start_schedule < current_timestamp AND s.end_schedule < current_timestamp", nativeQuery = true)
    List<Schedule> findScheduleByClosed();	
	
	@Query(value ="SELECT s.id, s.title, s.description, s.start_schedule, s.total_approved, s.total_reproved, s.total_votes, s.end_schedule FROM public.schedule s WHERE s.start_schedule < current_timestamp AND s.end_schedule > current_timestamp AND s.id = :Id", nativeQuery = true)
	Optional<Schedule> findScheduleOpenById(@Param("Id") Long id);
}

