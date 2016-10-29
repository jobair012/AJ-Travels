package team.fibonacci.aj_travels.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.fibonacci.aj_travels.domain.User;
import team.fibonacci.aj_travels.service.UserRoleService;
import team.fibonacci.aj_travels.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value={"", "/search"}, method = RequestMethod.GET)
	public ModelAndView showAdminPage() {

		ModelAndView model = new ModelAndView("admin");

		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showAdminCreation() {

		ModelAndView model = new ModelAndView("adminCreationForm");
		
		model.addObject("user", new User());		
		model.addObject("userRole", userRoleService.getUserRoleMapData());

		return model;
	}

	@RequestMapping(value="/doCreateOrUpdate", method=RequestMethod.POST)
	public ModelAndView doCreateOrUpdate(@ModelAttribute("user") @Valid User user, BindingResult result, HttpServletRequest request){
			
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("adminCreationForm");		
			model.addObject("userRole", userRoleService.getUserRoleMapData());	
			
			return model;
		}
			
			
		if(request.getParameter("action").equals("create")){
			userService.create(user, request.getUserPrincipal().getName());
		}else{
			userService.update(user, request.getUserPrincipal().getName());
		}
		
		return new ModelAndView("redirect:/admin/create");
	}
	
}
