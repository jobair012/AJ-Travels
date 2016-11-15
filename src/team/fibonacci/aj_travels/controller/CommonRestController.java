package team.fibonacci.aj_travels.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import team.fibonacci.aj_travels.service.AreaService;
import team.fibonacci.aj_travels.service.CityService;
import team.fibonacci.aj_travels.service.CountryService;
import team.fibonacci.aj_travels.service.StateService;

@RestController
@RequestMapping(value="/common")
public class CommonRestController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "getAllCountry", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getAllCountryMapData() {

		List<Map<String, Object>> countryList = countryService.getAllCountryListMapData();
		
		return countryList;
	}
	
	@RequestMapping(value = "getAllStateByCountryId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getAllStateByCountryId(HttpServletRequest request) {

		String countryId = request.getParameter("countryId");
		
		List<Map<String, Object>> stateList = stateService.getAllStateByCountryId(countryId);
		
		return stateList;
	}
	
	@RequestMapping(value = "getAllCityByStateId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getAllCityByStateId(HttpServletRequest request) {

		String stateId =request.getParameter("stateId");
		
		List<Map<String, Object>> cityList = cityService.getAllCityByStateId(stateId);
		
		return cityList;
	}
	
	@RequestMapping(value = "getAllAreaByCityId", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Map<String, Object>> getAllAreaByCityId(HttpServletRequest request) {
		
		String cityId = request.getParameter("cityId");
		
		List<Map<String, Object>> areaList = areaService.getAllAreaByCityId(cityId);
		
		return areaList;
	}
}
