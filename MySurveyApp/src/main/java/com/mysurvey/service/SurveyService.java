package com.mysurvey.service;

import java.util.List;

import com.mysurvey.entity.Survey;

public interface SurveyService {

	void addSurvey(Survey survey);

	void updateSurvey(Survey survey);

	Survey getBySurveyId(Integer surveyId);

	List<Survey> getAllSurvey();

	void deleteSurvey(Integer surveyId);

}
