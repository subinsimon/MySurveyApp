package com.mysurvey.repository;

import java.util.List;

import com.mysurvey.entity.Survey;

public interface SurveyDao {

	void addSurvey(Survey survey);

	void updateSurvey(Survey survey);

	Survey getSurveyById(Integer surveyId);

	List<Survey> getAllSurvey();

	void deleteSurvey(Integer surveyId);

}
