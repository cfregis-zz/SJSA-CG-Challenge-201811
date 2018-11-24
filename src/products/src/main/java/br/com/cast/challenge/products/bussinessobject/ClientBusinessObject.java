package br.com.cast.challenge.products.bussinessobject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.model.Client;
import br.com.cast.challenge.products.repository.ClientRepository;

@Component
public class ClientBusinessObject {
	
	@Autowired
	private ClientRepository clientRepository;


	public List<Client> list() {
		return (List<Client>) clientRepository.findAll();
	}

	public Client findById(Integer id) {
		return clientRepository.findById(id).get();
	}

	public Client registerNewClient(Client client) {
		client.getAddress().setClient(client);
		return clientRepository.save(client);
	}

	public Client update(Client client) {
		client.getAddress().setClient(client);
		return clientRepository.save(client);
	}


}
