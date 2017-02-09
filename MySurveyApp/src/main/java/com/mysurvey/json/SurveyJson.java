package com.mysurvey.json;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.mysurvey.entity.Sections;

public class SurveyJson {
	
	private Integer id;
	
	private String surveyName;
	
	private String surveydecsription;
	
	private Date startDate;
	
	private Date endDate;
	
	private Integer createdBy;

	private Set<SectionsJson> sections;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveydecsription() {
		return surveydecsription;
	}

	public void setSurveydecsription(String surveydecsription) {
		this.surveydecsription = surveydecsription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Set<SectionsJson> getSections() {
		return sections;
	}

	public void setSections(Set<SectionsJson> sections) {
		this.sections = sections;
	}

}
