package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.Ticket;


@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Integer, Ticket> implements TicketDao {

	static final Logger logger = LoggerFactory.getLogger(TicketDaoImpl.class);
	
	public Ticket findById(int id) {
		Ticket ticket = getByKey(id);
		
		return ticket;
	}

	public Ticket findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", sso));
		Ticket ticket = (Ticket)crit.uniqueResult();
		
		return ticket;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> findAllTickets() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("type"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Ticket> tickets = (List<Ticket>) criteria.list();
	
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return tickets;
	}

	public void save(Ticket ticket) {
		persist(ticket);
	}

	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", sso));//ssoId
		Ticket ticket = (Ticket)crit.uniqueResult();
		delete(ticket);
	}

}
