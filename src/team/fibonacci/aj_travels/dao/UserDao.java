package team.fibonacci.aj_travels.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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
	public Map<String, Object> getSearchResult(Map<String, Object> searchParameters) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		Criteria criteria = session().createCriteria(User.class);
		
		if(!ObjectUtils.isEmpty(searchParameters.get("username")) ){
			criteria.add(Restrictions.eq("username", searchParameters.get("username")));
		}
				
		if(!ObjectUtils.isEmpty(searchParameters.get("fromDate"))){
			criteria.add(Restrictions.ge("createdStamp", searchParameters.get("fromDate")));
		}
		
		if(!ObjectUtils.isEmpty(searchParameters.get("toDate"))){
			criteria.add(Restrictions.le("createdStamp", searchParameters.get("toDate")));
		}
		
		Integer size = criteria.list().size();
		
		if(!ObjectUtils.isEmpty(searchParameters.get("start"))){
			criteria.setFirstResult(Integer.valueOf(searchParameters.get("start").toString()));
		}
		
		if(!ObjectUtils.isEmpty(searchParameters.get("length"))){
			criteria.setMaxResults(Integer.valueOf(searchParameters.get("length").toString()));
		}
		
		criteria.addOrder(Order.desc("createdStamp"));
		
		List<User> userList = criteria.list();
		
		result.put("size", size);		
		result.put("result", userList);	
		
		return result;
	}
	

	public User getUserByUsername(String username) {
		
		User user = (User) session().get(User.class, username);
		return user;
	}
}
