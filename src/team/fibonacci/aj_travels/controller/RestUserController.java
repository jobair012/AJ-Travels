package team.fibonacci.aj_travels.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.fibonacci.aj_travels.dao.UserDao;
import team.fibonacci.aj_travels.domain.User;
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
	
	@RequestMapping(value = "doSearchUser", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String doSearch(HttpServletRequest request, HttpServletResponse response) throws ParseException, JsonProcessingException{
				
		ObjectMapper mapper = new ObjectMapper();		
		String token = request.getParameter("search[value]");
		
		Map<String, Object> searchParameters = new HashMap<String, Object>();
		searchParameters.put("username", request.getParameter("username"));
		searchParameters.put("fromDate", request.getParameter("fromDate"));
		searchParameters.put("toDate", request.getParameter("toDate"));
		searchParameters.put("length", request.getParameter("length"));
		searchParameters.put("start", request.getParameter("start"));
		
		List<User> searchResult = userService.getSearchResult(searchParameters);
		
		searchResult = userService.getUserListBasedOnSearchToken(token, searchResult);
		
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("aaData", searchResult);
		mapData.put("iTotalRecords", userService.totalNumberOfRecords(searchParameters));
		mapData.put("iTotalDisplayRecords", searchResult.size());
		
		String searchResultPrettyString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapData);
		
		return searchResultPrettyString;
	}
}
