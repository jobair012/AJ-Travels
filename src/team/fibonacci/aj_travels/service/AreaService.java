package team.fibonacci.aj_travels.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import team.fibonacci.aj_travels.dao.AreaDao;
import team.fibonacci.aj_travels.domain.Area;

@Service
public class AreaService {
	
	@Autowired
	private AreaDao areaDao;

	public List<Map<String, Object>> getAllAreaByCityId(String cityId) {
		
		Long cityIdLong = Long.valueOf(0);
		if(!ObjectUtils.isEmpty(cityId)){
			cityIdLong = Long.valueOf(cityId);
		}
		
		List<Area> areaList = areaDao.getAllAreaByCityId(cityIdLong);
		List<Map<String, Object>> areaListMapDate = new ArrayList<Map<String, Object>>();
	
		for(Area area : areaList){
			Map<String, Object> mapData = new HashMap<String, Object>();
			
			mapData.put("label", area.getAreaName());
			mapData.put("value", area.getAreaId());
			
			areaListMapDate.add(mapData);
		}
		
		return areaListMapDate;		
	}
}
