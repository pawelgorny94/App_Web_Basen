package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ClientDao;
import com.websystique.springmvc.dao.UserDao;
import com.websystique.springmvc.model.Client;
import com.websystique.springmvc.model.User;


@Service("clientService")
@Transactional
public class ClientServiceImpl  implements ClientService{ 

	
	@Autowired
	private ClientDao dao;
	
	
	@Override
	public Client findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Client findBySSO(String sso) {
		Client client = dao.findBySSO(sso);
		return client;
	}

	@Override
	public void saveClient(Client client) {
		dao.save(client);
		
	}

	@Override
	public void updateClient(Client client) {
		Client entity = dao.findById(client.getId());
		if(entity!=null){
			entity.setId(client.getId());
			
			entity.setFirstName(client.getFirstName());
			entity.setLastName(client.getLastName());
			
		}
		
	}

	@Override
	public void deleteClientBySSO(String sso) {
		dao.deleteBySSO(sso);
		
	}

	@Override
	public List<Client> findAllClient() {
		return dao.findAllClients();
	}

	@Override
	public boolean isUserSSOUnique(Integer id, String sso) {
		// TODO Auto-generated method stub
		return false;
	}

}
