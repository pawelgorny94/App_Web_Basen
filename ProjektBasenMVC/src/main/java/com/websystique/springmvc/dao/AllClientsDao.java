package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.AllClients;
import com.websystique.springmvc.model.Client;

public interface AllClientsDao {

	
	AllClients findById(int id);
	
	AllClients findBySSO(String sso);
	
	void save(AllClients client);
	
	void deleteBySSO(Integer sso);
	
	List<AllClients> findAllClients();
}
