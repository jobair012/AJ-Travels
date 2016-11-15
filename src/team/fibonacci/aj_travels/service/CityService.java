package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import team.fibonacci.aj_travels.dao.CityDao;
import team.fibonacci.aj_travels.domain.City;

@Service
public class CityService {
	
	@Autowired
	private CityDao cityDao;

	public List<Map<String, Object>> getAllCityByStateId(String stateId) {

		Long stateIdLong = Long.valueOf(0);
		if(!ObjectUtils.isEmpty(stateId)){
			stateIdLong = Long.valueOf(stateId);
		}
		List<City> cityList = cityDao.getAllCityByStateId(stateIdLong);
		List<Map<String, Object>> cityListMapDate = new ArrayList<Map<String, Object>>();
	
		for(City city : cityList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", city.getCityName());
			mapData.put("value", city.getCityId());
			
			cityListMapDate.add(mapData);
		}
		
		return cityListMapDate;		
	}

}
