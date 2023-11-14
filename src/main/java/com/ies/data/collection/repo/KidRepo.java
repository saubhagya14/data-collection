package com.ies.data.collection.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.data.collection.entity.DcKidEntity;

public interface KidRepo extends JpaRepository<DcKidEntity, Integer> {
	public List<DcKidEntity> findByCaseNo(Integer caseNumber);
}
