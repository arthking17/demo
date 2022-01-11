package tn.itss.t24.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.itss.t24.model.Client;
import tn.itss.t24.repository.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	ClientRepository clientRepo;
	private static final Logger l = LogManager.getLogger(IClientService.class);
	  
	@Override
	public List<Client> getAllClients() {
		List<Client> clients = (List<Client>) clientRepo.findAll();
	    for (Client client : clients) {
	      l.info("client list : " + client);
	    }
	    return clients;
	}

	@Override
	public Client addClient(Client c) {
		return clientRepo.save(c);
	}

	@Override
	public void deleteClient(String id) {
		clientRepo.deleteById(id);
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepo.save(c);
	}

	@Override
	public Client getClient(String id) {
		return clientRepo.findById(id).get();
	}

}
