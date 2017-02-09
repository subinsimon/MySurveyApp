package com.mysurvey.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="SECTIONS")
@Proxy(lazy=false)
public class Sections implements Serializable{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="SECTION_NAME")
	private String sectionName;
	@Column(name="SECTION_DESCRIPTION")
	private String sectionDescription;
	@Column(name="SECTION_ORDER")
	private Integer SectionOrder;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SURVEY_ID")
	private Survey survey;
	
	@OneToMany(mappedBy="sections", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Questions> questions;

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

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Set<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SectionOrder == null) ? 0 : SectionOrder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sectionDescription == null) ? 0 : sectionDescription.hashCode());
		result = prime * result + ((sectionName == null) ? 0 : sectionName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sections other = (Sections) obj;
		if (SectionOrder == null) {
			if (other.SectionOrder != null)
				return false;
		} else if (!SectionOrder.equals(other.SectionOrder))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sectionDescription == null) {
			if (other.sectionDescription != null)
				return false;
		} else if (!sectionDescription.equals(other.sectionDescription))
			return false;
		if (sectionName == null) {
			if (other.sectionName != null)
				return false;
		} else if (!sectionName.equals(other.sectionName))
			return false;
		return true;
	}

}
