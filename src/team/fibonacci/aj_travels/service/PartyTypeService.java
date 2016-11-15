package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.fibonacci.aj_travels.dao.PartyTypeDao;
import team.fibonacci.aj_travels.domain.PartyType;

@Service
public class PartyTypeService {

	@Autowired
	private PartyTypeDao partyTypeDao;
	
	public List<Map<String, Object>> getPartyTypeMapData(){
		
		List<PartyType> partyTypeList = partyTypeDao.getAllPartyType();		
		List<Map<String, Object>> partyTypeMapData = new ArrayList<Map<String, Object>>();
		
		for(PartyType partyType : partyTypeList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", partyType.getPartyTypeName());
			mapData.put("value", partyType.getPartyTypeId());
			
			partyTypeMapData.add(mapData);
		}
		
		return partyTypeMapData;
	}
}
