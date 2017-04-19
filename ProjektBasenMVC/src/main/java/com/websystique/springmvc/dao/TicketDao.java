package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.Ticket;

public interface TicketDao {
	
	Ticket findById(int id);
	
	Ticket findBySSO(String sso);
	
	void save(Ticket user);
	
	void deleteBySSO(String sso);
	
	List<Ticket> findAllTickets();

}
