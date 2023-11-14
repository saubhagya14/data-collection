package com.ies.data.collection.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.data.collection.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
