package team.fibonacci.aj_travels.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Boolean isDuplicateUsername(String username){
		
		return userDao.checkDuplicateUsername(username);
	}

	public List<Map<String, Object>> getAllNameList() {
		
		List<User> userList = userDao.getUserList();
		
		List<Map<String, Object>> jsonUserList = new ArrayList<Map<String, Object>>();
		
		for(User user : userList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", user.getUsername());
			
			jsonUserList.add(mapData);
		}
		
		return jsonUserList;
	}

	public List<Map<String, Object>> getNameAndUsernameList() {
		
		List<UserDetail> userList = userDetailDao.getUserDetailList();	
		System.out.println(userList.get(0));
		List<Map<String, Object>> nameAndUsernameList = new ArrayList<Map<String, Object>>();
	
		for(UserDetail user : userList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", user.getName()+" ("+user.getUsername()+")");
			mapData.put("value", user.getUsername());
			
			nameAndUsernameList.add(mapData);
		}
		
		return nameAndUsernameList;
	}

	public void create(User user, String createdBy) {
		
		UserDetail userDetail = user.getUserDetail();
		Timestamp lastUpdatedStamp = new Timestamp(new java.util.Date().getTime());

		userDetail.setUsername(user.getUsername());
		userDetail.setCreatedBy(createdBy);
		userDetail.setLastUpdatedBy(createdBy);
		userDetail.setCreatedStamp(lastUpdatedStamp);
		userDetail.setLastUpdatedStamp(lastUpdatedStamp);
				
		user.setCreatedBy(createdBy);
		user.setLastUpdatedBy(createdBy);
		user.setCreatedStamp(lastUpdatedStamp);
		user.setLastUpdatedStamp(lastUpdatedStamp);
		user.setUserDetail(userDetail);
		
		userDao.saveOrUpdateUser(user);
	}
	
	public void update(User user, String updatedBy) {
		
		UserDetail userDetail = user.getUserDetail();
		Timestamp lastUpdatedStamp = new Timestamp(new java.util.Date().getTime());

		userDetail.setUsername(user.getUsername());
		userDetail.setLastUpdatedBy(updatedBy);
		userDetail.setLastUpdatedStamp(lastUpdatedStamp);
				
		user.setLastUpdatedBy(updatedBy);
		user.setLastUpdatedStamp(lastUpdatedStamp);
		user.setUserDetail(userDetail);
		
		userDao.saveOrUpdateUser(user);
	}

}
