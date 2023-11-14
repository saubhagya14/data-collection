package com.ies.data.collection.binding;

import java.util.List;

public class Kids {

	private Integer caseNumber;
	private Integer userId;
	private List<Kid> kids;

	public Integer getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Kid> getKids() {
		return kids;
	}

	public void setKids(List<Kid> kids) {
		this.kids = kids;
	}

}
