package com.ies.data.collection.binding;

import java.util.List;

import com.ies.data.collection.entity.DcEducationEntity;
import com.ies.data.collection.entity.DcIncomeEntity;
import com.ies.data.collection.entity.DcKidEntity;
import com.ies.data.collection.entity.Plan;

public class Summery {

	public Plan plan;
	public DcIncomeEntity incomeEntity;
	public DcEducationEntity educationEntity;
	public List<DcKidEntity> kids;
	
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public DcIncomeEntity getIncomeEntity() {
		return incomeEntity;
	}
	public void setIncomeEntity(DcIncomeEntity incomeEntity) {
		this.incomeEntity = incomeEntity;
	}
	public DcEducationEntity getEducationEntity() {
		return educationEntity;
	}
	public void setEducationEntity(DcEducationEntity educationEntity) {
		this.educationEntity = educationEntity;
	}
	public List<DcKidEntity> getKids() {
		return kids;
	}
	public void setKids(List<DcKidEntity> kids) {
		this.kids = kids;
	}
	
	
	
	
}
