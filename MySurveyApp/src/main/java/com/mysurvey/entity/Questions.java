package com.mysurvey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="QUESTIONS")
@Proxy(lazy=false)
public class Questions implements Serializable{
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="QUESTION_TEXT")
	private String questionText;
	@Column(name="QUESTION_DESCRIPTION")
	private String questionDescription;
	@Column(name="QUESTION_TYPE")
	private String questionType;
	@Column(name="QUESTION_NUMBER")
	private Integer questionNumber;
	@Column(name="QUESTION_ISVISIBLE")
	private Boolean isVisible;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SECTION_ID")
	private Sections sections;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Sections getSection() {
		return sections;
	}

	public void setSection(Sections section) {
		this.sections = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isVisible == null) ? 0 : isVisible.hashCode());
		result = prime * result + ((questionDescription == null) ? 0 : questionDescription.hashCode());
		result = prime * result + ((questionNumber == null) ? 0 : questionNumber.hashCode());
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
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
		Questions other = (Questions) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isVisible == null) {
			if (other.isVisible != null)
				return false;
		} else if (!isVisible.equals(other.isVisible))
			return false;
		if (questionDescription == null) {
			if (other.questionDescription != null)
				return false;
		} else if (!questionDescription.equals(other.questionDescription))
			return false;
		if (questionNumber == null) {
			if (other.questionNumber != null)
				return false;
		} else if (!questionNumber.equals(other.questionNumber))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (questionType == null) {
			if (other.questionType != null)
				return false;
		} else if (!questionType.equals(other.questionType))
			return false;
		return true;
	}

}
