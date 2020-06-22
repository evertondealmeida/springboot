package com.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schedule.model.Associated;

public interface AssociatedRepository extends JpaRepository<Associated, Long> {
	@Query(value ="SELECT v.id FROM public.associated v WHERE v.cpf = :cpf", nativeQuery = true)
	Integer checkExistence(@Param("cpf") String cpf);


}
