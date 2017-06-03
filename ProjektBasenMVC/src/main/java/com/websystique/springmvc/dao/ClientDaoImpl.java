package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.User;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
	
	public Client findById(int id) {
		Client client = getByKey(id);
		
		return client;
	}

	public Client findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		Client client = (Client)crit.uniqueResult();
		
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Client> clients = (List<Client>) criteria.list();
		
		
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return clients;
	}
      
	public void save(Client client) {
		persist(client);
	}

	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", sso));//ssoId
		Client client = (Client)crit.uniqueResult();
		delete(client);
	}

}
