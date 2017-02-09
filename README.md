# MySurveyApp
This app helps to create a survey with diferent sections and questions in it.
Used Spring MVC,Hibernate,PostGres DB and RestFul Webservices

URLs
GET : http://localhost:8080/MySurveyApp/mySurvey/surveys/survey?surveyId=7
GET : http://localhost:8080/MySurveyApp/mySurvey/surveys/
POST : http://localhost:8080/MySurveyApp/mySurvey/surveys
PUT : http://localhost:8080/MySurveyApp/mySurvey/surveys/survey
DELETE : http://localhost:8080/MySurveyApp/mySurvey/surveys?surveyId=6
Sample GET request
http://localhost:8080/MySurveyApp/mySurvey/surveys/survey?surveyId=7
{
	"id": 7,
	"surveyName": "Test Survey",
	"surveydecsription": null,
	"startDate": 1486508400000,
	"endDate": 1486508400000,
	"createdBy": 1,
	"sections": [{
		"id": 11,
		"sectionName": "section1",
		"sectionDescription": "test Section",
		"questions": [{
			"id": 1,
			"questionText": "question2",
			"questionDescription": "question2 description",
			"questionType": "question2",
			"questionNumber": 2,
			"isVisible": true
		}, {
			"id": 2,
			"questionText": "question1",
			"questionDescription": "question1 description",
			"questionType": "question1",
			"questionNumber": 1,
			"isVisible": true
		}],
		"sectionOrder": 1
	}, {
		"id": 12,
		"sectionName": "section2",
		"sectionDescription": "test Section 2",
		"questions": [{
			"id": 3,
			"questionText": "question3",
			"questionDescription": "question3 description",
			"questionType": "question3",
			"questionNumber": 3,
			"isVisible": true
		}, {
			"id": 8,
			"questionText": "question4",
			"questionDescription": "question4 description",
			"questionType": "question4",
			"questionNumber": 4,
			"isVisible": true
		}],
		"sectionOrder": 2
	}]
}
