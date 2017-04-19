package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.AllClients;
import com.websystique.springmvc.model.Client;

public interface AllClientsService {

	AllClients findById(int id);
	
	AllClients findBySSO(String sso);
		
		void saveClient(AllClients client);
		
		void updateClient(AllClients client);
		
		void deleteClientBySSO(Integer sso);

		List<AllClients> findAllClient(); 
		
		boolean isUserSSOUnique(Integer id, String sso);
	
}
