package team.fibonacci.aj_travels.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.Area;

@Component
@Transactional
public class AreaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Area> getAllArea() {
		
		return session().createCriteria(Area.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Area> getAllAreaByCityId(Long cityId) {
		
		Criteria criteria = session().createCriteria(Area.class);
		
		if(cityId > 0){
			criteria.add(Restrictions.eq("city.cityId", cityId));
		}
	
		List<Area> areaList = criteria.list();

		return areaList;
	}
}
