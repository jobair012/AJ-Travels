package team.fibonacci.aj_travels.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import team.fibonacci.aj_travels.domain.Party;
import team.fibonacci.aj_travels.service.PartyService;

@RestController
@RequestMapping(value="party")
public class PartyRestController {
	
	@Autowired
	private PartyService partyService;

	@RequestMapping(value = "getAllPartyName", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<String> getAllPartyName() {

		List<String> partyNameList = partyService.getAllPartyName();
		
		return partyNameList;
	}
	
	@RequestMapping(value = "doSearchParty", method=RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String doSearch(HttpServletRequest request, HttpServletResponse response) throws ParseException, JsonProcessingException{
				
		ObjectMapper mapper = new ObjectMapper();		
		String token = request.getParameter("search[value]");

		Map<String, Object> searchParameters = new HashMap<String, Object>();
		searchParameters.put("partyTypeId", request.getParameter("partyTypeId"));
		searchParameters.put("partyId", request.getParameter("partyId"));
		searchParameters.put("partyName", request.getParameter("partyName"));
		searchParameters.put("fromDate", request.getParameter("fromDate"));
		searchParameters.put("toDate", request.getParameter("toDate"));
		searchParameters.put("length", request.getParameter("length"));
		searchParameters.put("start", request.getParameter("start"));
				
		@SuppressWarnings("unchecked")
		List<Party> searchResult = (List<Party>) partyService.getSearchResult(searchParameters).get("result");
		
		searchResult = partyService.getPartyListBasedOnSearchToken(token, searchResult);
		
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("aaData", searchResult);
		mapData.put("iTotalRecords", partyService.getSearchResult(searchParameters).get("size"));
		mapData.put("iTotalDisplayRecords", partyService.getSearchResult(searchParameters).get("size"));
		
		String searchResultPrettyString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapData);
		
		return searchResultPrettyString;
	}
}
