package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ClientDao;
import com.websystique.springmvc.dao.TicketDao;
import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.Ticket;

@Service("ticketService")
@Transactional
public class TicketServiceImpl  implements TicketService{

	

	@Autowired
	private TicketDao dao;
	
	@Override
	public Ticket findById(int id) {
		return dao.findById(id);
	}

	
	@Override
	public Ticket findByType(String type) {
		return dao.findByType(type);
	}


	@Override
	public Ticket findBySSO(String sso) {
		Ticket ticket = dao.findBySSO(sso);
		return ticket;
	}

	@Override
	public void saveTicket(Ticket ticket) {
		dao.save(ticket);
		
	}

	@Override
	public void updateTicket(Ticket ticket) {
		Ticket entity = dao.findBySSO(ticket.getType());
		if(entity!=null){
			
			
			entity.setType(ticket.getType());
			entity.setPrice(ticket.getPrice());
			
		}
		
	}

	@Override
	public void deleteTicketBySSO(String sso) {
		dao.deleteBySSO(sso);
		
	}

	@Override
	public List<Ticket> findAllTicket() {
		return dao.findAllTickets();
	}



	

}
