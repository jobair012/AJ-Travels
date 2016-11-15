package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import team.fibonacci.aj_travels.dao.StateDao;
import team.fibonacci.aj_travels.domain.State;

@Service
public class StateService {

	@Autowired
	private StateDao stateDao;

	public List<Map<String, Object>> getAllStateByCountryId(String countryId) {
		
		Long countryIdLong = Long.valueOf(0);
		if(!ObjectUtils.isEmpty(countryId)){
			countryIdLong = Long.valueOf(countryId);
		}
		List<State> stateList = stateDao.getAllStateByCountryId(countryIdLong);
		List<Map<String, Object>> stateListMapDate = new ArrayList<Map<String, Object>>();
	
		for(State state : stateList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", state.getStateName());
			mapData.put("value", state.getStateId());
			
			stateListMapDate.add(mapData);
		}
		
		return stateListMapDate;		
	}	
	
}
