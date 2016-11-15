package team.fibonacci.aj_travels.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.State;

@Component
@Transactional
public class StateDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<State> getAllState() {
		
		return session().createCriteria(State.class).list();
	}
		
	@SuppressWarnings({ "unchecked" })
	public List<State> getAllStateByCountryId(Long countryId) {
		
		Criteria criteria = session().createCriteria(State.class);
		
		if(countryId > 0){
			criteria.add(Restrictions.eq("country.countryId", countryId));
		}
	
		List<State> stateList = criteria.list();

		return stateList;
		
	}
}
