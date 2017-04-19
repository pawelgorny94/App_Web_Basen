package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.AllClientsDao;
import com.websystique.springmvc.dao.ClientDao;
import com.websystique.springmvc.model.AllClients;
import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.User;

@Service("allclientsService")
@Transactional
public class AllClientsServiceImpl implements AllClientsService {

	@Autowired
	private AllClientsDao dao;
	
	
	@Override
	public AllClients findById(int id) {
		return dao.findById(id);
	}

	@Override
	public AllClients findBySSO(String sso) {
		AllClients client = dao.findBySSO(sso);
		return client;
	}

	@Override
	public void saveClient(AllClients client) {
		dao.save(client);
		
	}

	@Override
	public void updateClient(AllClients client) {
		AllClients entity = dao.findById(client.getId());
		if(entity!=null){
			entity.setId(client.getId());
			
			entity.setFirstName(client.getFirstName());
			entity.setLastName(client.getLastName());
			entity.setPrice(client.getPrice());
			entity.setType(client.getType());
			
		}
		
		
	}

	@Override
	public void deleteClientBySSO(Integer sso) {
		dao.deleteBySSO(sso);
		
	}

	@Override
	public List<AllClients> findAllClient() {
		return dao.findAllClients();
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		AllClients user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

}
