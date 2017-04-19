package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.AllClients;
import com.websystique.springmvc.model.Client;
@Repository("allclientsDao")
public class AllClientsDaoImpl   extends AbstractDao<Integer, AllClients> implements AllClientsDao {
	static final Logger logger = LoggerFactory.getLogger(AllClientsDaoImpl.class);
	@Override
	public AllClients findById(int id) {
		AllClients client = getByKey(id);
		
		return client;
	}

	@Override
	public AllClients findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", sso));
		AllClients client = (AllClients)crit.uniqueResult();
		
		return client;
	}

	@Override
	public void save(AllClients client) {
		persist(client);
		
	}

	@Override
	public void deleteBySSO(Integer sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", sso));//ssoId
		AllClients client = (AllClients)crit.uniqueResult();
		delete(client);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AllClients> findAllClients() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<AllClients> clients = (List<AllClients>) criteria.list();
		
	
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return clients;
	}

}
