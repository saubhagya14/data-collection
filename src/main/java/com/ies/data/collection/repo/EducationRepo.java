package com.ies.data.collection.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.data.collection.entity.DcEducationEntity;

public interface EducationRepo extends JpaRepository<DcEducationEntity, Integer> {
	public DcEducationEntity findByCaseNo(Integer caseNumber);
}
