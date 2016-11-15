package team.fibonacci.aj_travels.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.PartyType;

@Component
@Transactional
public class PartyTypeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<PartyType> getAllPartyType() {
		
		return session().createCriteria(PartyType.class).list();
	}

}
