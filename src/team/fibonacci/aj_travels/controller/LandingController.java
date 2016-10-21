package team.fibonacci.aj_travels.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class LandingController {
	
	@RequestMapping(value={"", "/login"}, method=RequestMethod.GET)
	public ModelAndView showHome(HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("landingPage");		
		
		if(request.getUserPrincipal() != null){
			return new ModelAndView("redirect:/dashboard");
		}		
		
		return model; 		
	}

}
