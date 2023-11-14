package com.ies.data.collection.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.data.collection.binding.EducationDetails;
import com.ies.data.collection.binding.IncomeDetails;
import com.ies.data.collection.binding.Kids;
import com.ies.data.collection.binding.PlanSelection;
import com.ies.data.collection.service.DcService;

@RestController
public class DcController {

	@Autowired
	DcService service;
	
	@GetMapping("/get-plans")
	public Map<Integer, String> getPlans() {
		return service.getPlans();
	}
	
	@PostMapping("/select-plans")
	public Object setPlan(PlanSelection planSelection) {
		return service.updatePlnSelction(planSelection);
	}
	
	@PostMapping("/set-income")
	public Object setIncomeDetails(IncomeDetails incomeDetails) {
		return service.setIncomeDetails(incomeDetails);
	}
	
	@PostMapping("/set-education")
	public Object setEducationDetails(EducationDetails educationDetails) {
		return service.setEducationDetails(educationDetails);
	}
	
	@PostMapping("/set-kids")
	public Object setKidsDetails(Kids kid) {
		return service.setKidsDetails(kid);
	}
	
	@GetMapping("/summery")
	public Object getSummery(Integer caseNumber) {
		return service.getSummery(caseNumber);
	}
	
}
