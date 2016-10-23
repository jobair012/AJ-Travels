package team.fibonacci.aj_travels.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.domain.User;

@Transactional
@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserList(){		
		
		List<User> user = session().createCriteria(User.class).list();
		
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getUsernameList(){
		
		List<String> usernameList = session().createCriteria(User.class).setProjection(Projections.property("username")).list();
		
		return usernameList;
	}	

	public void saveOrUpdateUser(User user) {
		
		session().saveOrUpdate(user);
	}
	
	
	@SuppressWarnings("unchecked")
	public Boolean checkDuplicateUsername(String username){
		
		List<User> user = session().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
		
		Boolean existance = user.isEmpty() ? false : true;
		
		return existance;
	}

	@SuppressWarnings("unchecked")
	public List<User> getSearchResult(String username, Timestamp fromTimestamp, Timestamp toTimestamp) {
		
		Criteria criteria = session().createCriteria(User.class);
		
		if(!username.isEmpty())
		criteria.add(Restrictions.eq("username", username));
		
		if(fromTimestamp != null){
			criteria.add(Restrictions.ge("createdStamp", fromTimestamp));
		}
		
		if(toTimestamp != null){
			criteria.add(Restrictions.le("createdStamp", toTimestamp));
		}
		
		criteria.addOrder(Order.desc("createdStamp"));
		
		return criteria.list();
	}
}
