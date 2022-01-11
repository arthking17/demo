package tn.itss.t24.service;

import java.util.List;

import tn.itss.t24.model.Client;

public interface IClientService {
	public List<Client> getAllClients();
	public Client addClient(Client c);
	public void deleteClient(String id);
	public Client updateClient(Client c);
	public Client getClient(String id);
}
