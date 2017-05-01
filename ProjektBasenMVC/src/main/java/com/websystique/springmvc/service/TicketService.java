package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.Ticket;

public interface TicketService {
	
	Ticket findById(int id);
	Ticket findByType(String type);
	
	Ticket findBySSO(String sso);
		
		void saveTicket(Ticket ticket);
		
		void updateTicket(Ticket ticket);
		
		void deleteTicketBySSO(String sso);

		List<Ticket> findAllTicket(); 
		
		

}
