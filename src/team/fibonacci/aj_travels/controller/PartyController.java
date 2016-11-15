package team.fibonacci.aj_travels.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.fibonacci.aj_travels.domain.Party;
import team.fibonacci.aj_travels.service.PartyService;
import team.fibonacci.aj_travels.service.PartyTypeService;

@Controller
@RequestMapping(value = "/party")
public class PartyController {
	
	@Autowired
	private PartyTypeService partyTypeService;
	
	@Autowired
	private PartyService partyService;
	
	@RequestMapping(value={"", "/search"}, method = RequestMethod.GET)
	public ModelAndView showPartySearchPage() {

		ModelAndView model = new ModelAndView("partySearchForm");
		
		model.addObject("partyType", partyTypeService.getPartyTypeMapData());
		
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showAdminCreation() {

		ModelAndView model = new ModelAndView("partyRegistrationForm");
		
		model.addObject("party", new Party());	
		model.addObject("partyType", partyTypeService.getPartyTypeMapData());

		return model;
	}
	
	@RequestMapping(value="/doCreateOrUpdate", method=RequestMethod.POST)
	public ModelAndView doCreateOrUpdate(@ModelAttribute("party")  @Valid Party party, BindingResult result, HttpServletRequest request){
						
		if(result.hasErrors() || ObjectUtils.isEmpty(party.getPartyType().getPartyTypeId())){
			ModelAndView model = new ModelAndView("partyRegistrationForm");
			
			if(ObjectUtils.isEmpty(party.getPartyType().getPartyTypeId())){
				result.rejectValue("partyType.partyTypeId", "emptyPartyId", "may not be empty");
			}
			model.addObject("partyType", partyTypeService.getPartyTypeMapData());
			
			return model;
		}
		
		if(request.getParameter("action").equals("create")){
			partyService.create(party, request.getUserPrincipal().getName());
		}
//		else{
//			partyService.update(party, request.getUserPrincipal().getName());
//		}
		
		return new ModelAndView("redirect:/party");
	}
	
	@RequestMapping(value="/explore", method=RequestMethod.GET)
	public ModelAndView exploreParty(@RequestParam("partyId") String partyId){
			
		ModelAndView model = new ModelAndView("partyRegistrationForm");
		
		model.addObject("party", partyService.getPartyByPartyId(partyId));	
		model.addObject("partyType", partyTypeService.getPartyTypeMapData());

		return model;
	}
}
