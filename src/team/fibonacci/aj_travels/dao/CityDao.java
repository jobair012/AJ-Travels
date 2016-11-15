package team.fibonacci.aj_travels.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.City;

@Component
@Transactional
public class CityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<City> getAllCity() {
		
		return session().createCriteria(City.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<City> getAllCityByStateId(Long stateId) {
		
		Criteria criteria = session().createCriteria(City.class);
		
		if(stateId > 0){
			criteria.add(Restrictions.eq("state.stateId", stateId));
		}
	
		List<City> cityList = criteria.list();

		return cityList;
	}
}
