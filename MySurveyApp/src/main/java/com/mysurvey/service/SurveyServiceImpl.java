package com.mysurvey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysurvey.entity.Survey;
import com.mysurvey.repository.SurveyDao;

@Service
public class SurveyServiceImpl implements SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;

	@Transactional
	public void addSurvey(Survey survey) {
		
		surveyDao.addSurvey(survey);
		
	}

	@Transactional
	public void updateSurvey(Survey survey) {
		
		surveyDao.updateSurvey(survey);
		
	}

	@Transactional
	public Survey getBySurveyId(Integer surveyId) {
		
		return surveyDao.getSurveyById(surveyId);
	}

	@Transactional
	public List<Survey> getAllSurvey() {
		
		return surveyDao.getAllSurvey();
	}

	@Transactional
	public void deleteSurvey(Integer surveyId) {
		surveyDao.deleteSurvey(surveyId);
		
	}

}
