package team.fibonacci.aj_travels.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.fibonacci.aj_travels.dao.UserDao;
import team.fibonacci.aj_travels.dao.UserDetailDao;
import team.fibonacci.aj_travels.domain.User;
import team.fibonacci.aj_travels.domain.UserDetail;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailDao userDetailDao;
	
	
	public void userCreationOrModification(HttpServletRequest request){
		User user = createOrUpdateUser(request);
		createUserDetail(request, user);		
	}
	
	public User createOrUpdateUser(HttpServletRequest request) {
		
		User user = new User();
				
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String role = request.getParameter("role");
		String action = request.getParameter("action");		
		String lastUpdatedBy = request.getUserPrincipal().getName();				
		Timestamp lastUpdatedStamp = new Timestamp(new java.util.Date().getTime());
		
		Boolean enabled = status.equals("deactivate") ? false : true;	
		
		if(action.equals("create")){
			user.setCreatedBy(lastUpdatedBy);
			user.setCreatedStamp(lastUpdatedStamp);
		}
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(enabled);
		user.setRole(role);		
		user.setLastUpdatedBy(lastUpdatedBy);
		user.setLastUpdatedStamp(lastUpdatedStamp);
			
		userDao.saveOrUpdateUser(user);
		
		return user;		
	}
	
	public void createUserDetail(HttpServletRequest request, User user){
		
		UserDetail userDetail = new UserDetail();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");	
		String action = request.getParameter("action");		
		String lastUpdatedBy = request.getUserPrincipal().getName();				
		Timestamp lastUpdatedStamp = new Timestamp(new java.util.Date().getTime());
		
		if(action.equals("create")){
			userDetail.setCreatedBy(lastUpdatedBy);
			userDetail.setCreatedStamp(lastUpdatedStamp);
		}		
		
		userDetail.setUser(user);
		userDetail.setName(name);
		userDetail.setEmail(email);
		userDetail.setPhoneNo(phoneNo);
		userDetail.setLastUpdatedBy(lastUpdatedBy);
		userDetail.setLastUpdatedStamp(lastUpdatedStamp);
		
		userDetailDao.saveOrUpdateUserDetail(userDetail);
	}

}
