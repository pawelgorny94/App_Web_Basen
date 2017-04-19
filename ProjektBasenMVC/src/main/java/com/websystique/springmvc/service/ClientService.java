package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.User;

public interface ClientService {

	
Client findById(int id);
	
Client findBySSO(String sso);
	
	void saveClient(Client client);
	
	void updateClient(Client client);
	
	void deleteClientBySSO(String sso);

	List<Client> findAllClient(); 
	
	boolean isUserSSOUnique(Integer id, String sso);
}
