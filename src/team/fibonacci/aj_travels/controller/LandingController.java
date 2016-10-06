package team.fibonacci.aj_travels.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.fibonacci.aj_travels.dao.UserDao;
import team.fibonacci.aj_travels.domain.User;

@Controller
@RequestMapping(value="/")
public class LandingController {

	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView showHome(){
		
		ModelAndView model = new ModelAndView("landingPage");		
		
		User user = new User();
		user.setCreatedBy("jobair012");
		user.setEnabled(true);
		user.setRole("ROLE_ADMIN");
		user.setPassword("cse-1133");
		user.setUsername("testuser");
		user.setCreatedStamp(new Timestamp(new java.util.Date().getTime()));
		
		userDao.saveOrUpdateUser(user);
		
//		System.out.println(userDao.getAllUser().get(0).getPassword());
		
		return model; 
		
	}
}
