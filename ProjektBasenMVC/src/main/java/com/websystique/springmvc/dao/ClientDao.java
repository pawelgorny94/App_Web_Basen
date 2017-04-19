package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Client;

public interface ClientDao {

Client findById(int id);
	
	Client findBySSO(String sso);
	
	void save(Client user);
	
	void deleteBySSO(String sso);
	
	List<Client> findAllClients();
	
}
