package team.fibonacci.aj_travels.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.fibonacci.aj_travels.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAdminPage() {

		ModelAndView model = new ModelAndView("admin");

		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showAdminCreation() {

		ModelAndView model = new ModelAndView("adminCreationForm");

		return model;
	}

	@RequestMapping(value="/doCreateOrUpdate", method=RequestMethod.POST)
	public ModelAndView doCreateOrUpdate(HttpServletRequest request){
		
		userService.userCreationOrModification(request);
		
		return new ModelAndView("redirect:/admin/create");
	}
}
