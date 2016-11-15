package team.fibonacci.aj_travels.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import team.fibonacci.aj_travels.dao.PartyDao;
import team.fibonacci.aj_travels.domain.Contact;
import team.fibonacci.aj_travels.domain.Party;

@Service
public class PartyService {

	@Autowired
	private PartyDao partyDao;
	
	public void create(Party party, String createdBy) {
		
		Timestamp lastUpdatedStamp = new Timestamp(new java.util.Date().getTime());
		
		party.setCreatedBy(createdBy);
		party.setCreatedStamp(lastUpdatedStamp);
		party.setLastUpdatedBy(createdBy);
		party.setLastUpdatedStamp(lastUpdatedStamp);
		
		Contact contact = party.getContact();
		contact.setCreatedBy(createdBy);
		contact.setCreatedStamp(lastUpdatedStamp);
		contact.setLastUpdatedBy(createdBy);
		contact.setLastUpdatedStamp(lastUpdatedStamp);
		contact.setParty(party);
		
		partyDao.saveParty(party);
	}

	public List<String> getAllPartyName() {
		
		List<String> jsonPartyList = partyDao.getAllPartyName();	
		
		return jsonPartyList;
	}


	public Map<String, Object> getSearchResult(Map<String, Object> searchParameters) {
			
			Timestamp fromTimestamp = null;
			if(!ObjectUtils.isEmpty(searchParameters.get("fromDate"))){			
				try {
					fromTimestamp = CommonService.getTimestampFromString(searchParameters.get("fromDate").toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				searchParameters.put("fromDate", fromTimestamp);
			}
			
			Timestamp toTimestamp = null;
			if(!ObjectUtils.isEmpty(searchParameters.get("toDate"))){
				try {
					toTimestamp = CommonService.getTimestampFromString(searchParameters.get("toDate").toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				searchParameters.put("toDate", toTimestamp);
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("partyId"))){
				Long partyIdLong = Long.valueOf(searchParameters.get("partyId").toString());
				searchParameters.put("partyId", partyIdLong);
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("partyTypeId"))){
				Long partyTypeIdLong = Long.valueOf(searchParameters.get("partyTypeId").toString());
				searchParameters.put("partyTypeId", partyTypeIdLong);
			}
			
			if(ObjectUtils.isEmpty(searchParameters.get("length"))){
				searchParameters.put("length", "10");
			}
			
			return partyDao.getSearchResult(searchParameters);
	}
	
	public List<Party> getPartyListBasedOnSearchToken(String token, List<Party> partyList) {
		
		if (null != token && !token.equals("")) {
			List<Party> searchResult = new ArrayList<Party>();
			token = token.toUpperCase();
			for (Party party : partyList) {
				Date createdDate = new Date(party.getCreatedStamp().getTime());
			    String formatedDate = new SimpleDateFormat("yyyy-MM-dd").format(createdDate);
				if (party.getPartyId().toString().indexOf(token)!= -1 || party.getPartyName().toUpperCase().indexOf(token)!= -1
						|| party.getPartyType().getPartyTypeName().toString().toUpperCase().indexOf(token)!= -1 || formatedDate.toUpperCase().indexOf(token)!= -1) {
					searchResult.add(party);					
				}
				
			}
			partyList = searchResult;
			searchResult = null;
		}
		
		return partyList;
	}

	public Party getPartyByPartyId(String partyId) {
		
		
		return partyDao.getPartyByPartyId(Long.valueOf(partyId));
	}
}
