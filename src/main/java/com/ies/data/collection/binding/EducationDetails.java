package com.ies.data.collection.binding;

public class EducationDetails {

	private Integer caseNumber;
	private Integer userId;
	private String HighestDegree;
	private String graduationYear;
	private String universityName;
	
	public Integer getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(Integer caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getHighestDegree() {
		return HighestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		HighestDegree = highestDegree;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
