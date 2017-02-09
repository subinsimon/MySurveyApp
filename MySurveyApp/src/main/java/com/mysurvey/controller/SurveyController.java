package com.mysurvey.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysurvey.entity.Questions;
import com.mysurvey.entity.Sections;
import com.mysurvey.entity.Survey;
import com.mysurvey.json.QuestionJson;
import com.mysurvey.json.SectionsJson;
import com.mysurvey.json.SurveyJson;
import com.mysurvey.service.SurveyService;



@RestController
@RequestMapping("/mySurvey/")
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="/surveys", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addSurvey(@RequestBody SurveyJson surveyJson){
		surveyService.addSurvey(convertSurveyJsonToModel(surveyJson, false));
	}
	
	@RequestMapping(value="/surveys/survey", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateSurvey(@RequestBody SurveyJson surveyJson){
		surveyService.updateSurvey(convertSurveyJsonToModel(surveyJson, true));
	}
	
	@RequestMapping(value="/surveys/survey",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public SurveyJson getBySurveyId(@RequestParam("surveyId") Integer surveyId){
		return convertModelToJson(surveyService.getBySurveyId(surveyId));
	}
	
	@RequestMapping(value="/surveys",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<SurveyJson> getAllSurvey(){
		Set<SurveyJson> surveyJsons = new HashSet<SurveyJson>();
		for(Survey survey : surveyService.getAllSurvey()){
			surveyJsons.add(convertModelToJson(survey));
		}
		return surveyJsons;
	}
	
	@RequestMapping(value="/surveys",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteSurvey(@RequestParam("surveyId") Integer surveyId){
		surveyService.deleteSurvey(surveyId);
	}
	
	private Survey convertSurveyJsonToModel(SurveyJson surveyJson, Boolean isUpdate){
		Survey survey = new Survey();
		Set<Sections> sectionSet = new HashSet<Sections>();
		if(isUpdate){
			survey.setId(surveyJson.getId());
		}
		survey.setSurveyName(surveyJson.getSurveyName());
		survey.setSurveydecsription(surveyJson.getSurveydecsription());
		survey.setStartDate(surveyJson.getStartDate());
		survey.setEndDate(surveyJson.getEndDate());
		survey.setCreatedBy(surveyJson.getCreatedBy());
		
		if(!CollectionUtils.isEmpty(surveyJson.getSections())){
			for(SectionsJson sectionJson : surveyJson.getSections()){
				Sections sections = new Sections();
				if(isUpdate){
					sections.setId(sectionJson.getId());
				}
				sections.setSectionName(sectionJson.getSectionName());
				sections.setSectionDescription(sectionJson.getSectionDescription());
				sections.setSectionOrder(sectionJson.getSectionOrder());
				sections.setSurvey(survey);
				sections.setQuestions(convertQuestionJsonToModel(sectionJson.getQuestions(), sections, isUpdate));
				sectionSet.add(sections);
			}
		}
		survey.setSections(sectionSet);
		return survey;
	}

	private Set<Questions> convertQuestionJsonToModel(Set<QuestionJson> questionJsons,Sections sections, Boolean isUpdate) {
		Set<Questions> questions = new HashSet<Questions>();
		if(!CollectionUtils.isEmpty(questionJsons)){
			for(QuestionJson questionJson: questionJsons){
				Questions question = new Questions();
				if(isUpdate){
					question.setId(questionJson.getId());
				}
				question.setQuestionText(questionJson.getQuestionText());
				question.setQuestionDescription(questionJson.getQuestionDescription());
				question.setQuestionType(questionJson.getQuestionText());
				question.setQuestionNumber(questionJson.getQuestionNumber());
				question.setIsVisible(questionJson.getIsVisible());
				question.setSection(sections);
				questions.add(question);
			}
		}
		return questions;
	}
	
	private SurveyJson convertModelToJson(Survey survey){
		SurveyJson surveyJson = new SurveyJson();
		surveyJson.setId(survey.getId());
		surveyJson.setSurveyName(survey.getSurveyName());
		surveyJson.setSurveydecsription(survey.getSurveydecsription());
		surveyJson.setStartDate(survey.getStartDate());
		surveyJson.setEndDate(survey.getEndDate());
		surveyJson.setCreatedBy(survey.getCreatedBy());
		surveyJson.setSections(convertSectionModelToJson(survey.getSections()));
		return surveyJson;
	}

	private Set<SectionsJson> convertSectionModelToJson(Set<Sections> sections) {
		Set<SectionsJson> sectionJsonList = new HashSet<SectionsJson>();
		if(!CollectionUtils.isEmpty(sections)){
			for(Sections section : sections){
				SectionsJson sectionJson = new SectionsJson();
				sectionJson.setId(section.getId());
				sectionJson.setSectionName(section.getSectionName());
				sectionJson.setSectionDescription(section.getSectionDescription());
				sectionJson.setSectionOrder(section.getSectionOrder());
				sectionJson.setQuestions(convertQuestionModelToJson(section.getQuestions()));
				sectionJsonList.add(sectionJson);
			}
			
		}
		return sectionJsonList;
	}

	private Set<QuestionJson> convertQuestionModelToJson(Set<Questions> questions) {
		Set<QuestionJson> questionJsons = new HashSet<QuestionJson>();
		if(!CollectionUtils.isEmpty(questions)){
			for(Questions question : questions){
				QuestionJson questionJson = new QuestionJson();
				questionJson.setId(question.getId());
				questionJson.setQuestionText(question.getQuestionText());
				questionJson.setQuestionDescription(question.getQuestionDescription());
				questionJson.setQuestionType(question.getQuestionType());
				questionJson.setQuestionNumber(question.getQuestionNumber());
				questionJson.setIsVisible(question.getIsVisible());
				questionJsons.add(questionJson);
			}
		}
		return questionJsons;
	}

}
