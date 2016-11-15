package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.fibonacci.aj_travels.dao.CountryDao;
import team.fibonacci.aj_travels.domain.Country;

@Service
public class CountryService {

	@Autowired
	private CountryDao countryDao;
	
	public List<Map<String, Object>> getAllCountryListMapData() {
		
		List<Country> countryList = countryDao.getAllCountry();	
		
		List<Map<String, Object>> countryListMapData = new ArrayList<Map<String, Object>>();
	
		for(Country country : countryList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", country.getCountryName());
			mapData.put("value", country.getCountryId());
			
			countryListMapData.add(mapData);
		}
		
		return countryListMapData;
	}
}
