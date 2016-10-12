package team.fibonacci.aj_travels.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.UserDetail;

@Transactional
@Component
public class UserDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdateUserDetail(UserDetail userDetail) {
		
		session().saveOrUpdate(userDetail);
	}
}
