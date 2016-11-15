package team.fibonacci.aj_travels.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import team.fibonacci.aj_travels.domain.Party;

@Transactional
@Component
public class PartyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	public void saveParty(Party party) {
		Transaction tx = session().beginTransaction();

		if(ObjectUtils.isEmpty(party.getPartyType().getPartyTypeId())){
			party.setPartyType(null);
		}
		if(ObjectUtils.isEmpty(party.getContact().getCountry().getCountryId())){
			party.getContact().setCountry(null);
		}
		if(ObjectUtils.isEmpty(party.getContact().getState().getStateId())){
			party.getContact().setState(null);
		}
		if(ObjectUtils.isEmpty(party.getContact().getCity().getCityId())){
			party.getContact().setCity(null);
		}
		if(ObjectUtils.isEmpty(party.getContact().getArea().getAreaId())){
			party.getContact().setArea(null);
		}
		
		session().save(party);
		
		tx.commit();
	}
	
	public Long getLastInsertedId(){
//		BigInteger id = (BigInteger) session().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult();
		Criteria criteria = session().createCriteria(Party.class);
		criteria.setMaxResults(1);
		criteria.addOrder(Order.desc("partyId"));
		
		Long lastId = ((Party) criteria.list().get(0)).getPartyId();
		
		return lastId;
	}
		
		@SuppressWarnings("unchecked")
		public List<String> getAllPartyName(){
			
			List<String> partyNameList = session().createCriteria(Party.class).setProjection(Projections.property("partyName")).list();
			
			return partyNameList;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> getSearchResult(Map<String, Object> searchParameters) {
			
			Map<String, Object> result = new HashMap<String, Object>();
			Criteria criteria = session().createCriteria(Party.class);
			
			if(!ObjectUtils.isEmpty(searchParameters.get("partyTypeId")) ){
				criteria.add(Restrictions.eq("partyType.partyTypeId", searchParameters.get("partyTypeId")));
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("partyId")) ){
				criteria.add(Restrictions.eq("partyId", searchParameters.get("partyId")));
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("partyName")) ){
				criteria.add(Restrictions.eq("partyName", searchParameters.get("partyName")));
			}
					
			if(!ObjectUtils.isEmpty(searchParameters.get("fromDate"))){
				criteria.add(Restrictions.ge("createdStamp", searchParameters.get("fromDate")));
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("toDate"))){
				criteria.add(Restrictions.le("createdStamp", searchParameters.get("toDate")));
			}
			
			Integer size = criteria.list().size();
			
			if(!ObjectUtils.isEmpty(searchParameters.get("start"))){
				criteria.setFirstResult(Integer.valueOf(searchParameters.get("start").toString()));
			}
			
			if(!ObjectUtils.isEmpty(searchParameters.get("length"))){
				criteria.setMaxResults(Integer.valueOf(searchParameters.get("length").toString()));
			}
			
			criteria.addOrder(Order.desc("createdStamp"));
			
			List<Party> partyList = criteria.list();
			
			result.put("size", size);		
			result.put("result", partyList);	
			
			return result;
		}

		public Party getPartyByPartyId(Long partyId) {	
			
			Party party = (Party) session().get(Party.class, partyId);			
			return party;
		}	
	
}
