package com.mysurvey.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysurvey.entity.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addSurvey(Survey survey) {
		sessionFactory.getCurrentSession().save(survey);
		
	}

	public void updateSurvey(Survey survey) {
		sessionFactory.getCurrentSession().saveOrUpdate(survey);
		
	}

	public Survey getSurveyById(Integer surveyId) {
		if(surveyId == null){
			return null;
		}
		Session session = sessionFactory.getCurrentSession();
	//	Criteria query = session.createCriteria(Survey.class, surveyId.toString());
		return (Survey) session.load(Survey.class,surveyId);
	}

	public List<Survey> getAllSurvey() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Survey");
		return query.list();
	}

	public void deleteSurvey(Integer surveyId) {
		Session session = sessionFactory.getCurrentSession();
		Survey survey = (Survey) session.load(Survey.class, surveyId);
		session.delete(survey);
		
	}

}
