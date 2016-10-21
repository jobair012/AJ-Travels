package team.fibonacci.aj_travels.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import team.fibonacci.aj_travels.dao.UserDao;
import team.fibonacci.aj_travels.service.UserService;

@RestController
@RequestMapping(value="admin")
public class RestUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "checkDuplicateUsername", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String checkDuplicateUsername(String username) {

		System.out.println(userService.isDuplicateUsername(username));
		if (userService.isDuplicateUsername(username)) {
			return "Username '" + username + "' is already exists !";
		}

		return null;
	}
	
	@RequestMapping(value = "getAllUsername", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getUsernameList() {

		List<String> userList = userDao.getUsernameList();
		
		return userList;
	}
	
	@RequestMapping(value = "getNameAndUsernameList", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getNameAndUsernameList() {

		List<Map<String, Object>> userList = userService.getNameAndUsernameList();
		
		return userList;
	}
}
