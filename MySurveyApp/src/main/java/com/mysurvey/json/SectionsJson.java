package com.mysurvey.json;

import java.util.Set;

public class SectionsJson {
	
	private Integer id;
	
	private String sectionName;
	
	private String sectionDescription;
	
	private Integer SectionOrder;
	
	private Set<QuestionJson> questions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public void setSectionDescription(String sectionDescription) {
		this.sectionDescription = sectionDescription;
	}

	public Integer getSectionOrder() {
		return SectionOrder;
	}

	public void setSectionOrder(Integer sectionOrder) {
		SectionOrder = sectionOrder;
	}

	public Set<QuestionJson> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionJson> questions) {
		this.questions = questions;
	}

}
