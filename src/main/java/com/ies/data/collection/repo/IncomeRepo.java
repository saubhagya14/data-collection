package com.ies.data.collection.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.data.collection.entity.DcIncomeEntity;

public interface IncomeRepo extends JpaRepository<DcIncomeEntity, Integer> {
	public DcIncomeEntity findByCaseNo(Integer caseNumber);
}
