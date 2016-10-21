package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.fibonacci.aj_travels.dao.UserRoleDao;
import team.fibonacci.aj_travels.domain.UserRole;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public List<Map<String, Object>> getUserRoleMapData(){
		
		List<UserRole> userRoleList = userRoleDao.getAllUserRole();		
		List<Map<String, Object>> userRoleMapData = new ArrayList<Map<String, Object>>();
		
		for(UserRole userRole : userRoleList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", userRole.getDescription());
			mapData.put("value", userRole.getRole());
			
			userRoleMapData.add(mapData);
		}
		
		return userRoleMapData;
	}
}
