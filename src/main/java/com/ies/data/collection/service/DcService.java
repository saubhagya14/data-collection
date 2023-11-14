package com.ies.data.collection.service;

import java.util.Map;

import com.ies.data.collection.binding.EducationDetails;
import com.ies.data.collection.binding.IncomeDetails;
import com.ies.data.collection.binding.Kids;
import com.ies.data.collection.binding.PlanSelection;

public interface DcService {

	public Map<Integer, String> getPlans();
	public Object updatePlnSelction(PlanSelection planSelection);
	public Object setIncomeDetails(IncomeDetails incomeDetails);
	public Object setEducationDetails(EducationDetails educationDetails);
	public Object setKidsDetails(Kids kid);
	public Object getSummery(Integer caseNumber);
}
