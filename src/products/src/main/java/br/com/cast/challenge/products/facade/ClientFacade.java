package br.com.cast.challenge.products.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.bussinessobject.ClientBusinessObject;
import br.com.cast.challenge.products.model.Client;

@Component
public class ClientFacade {

	@Autowired
	private ClientBusinessObject clientBusinessObject;
	
	public List<Client> list() {
		return clientBusinessObject.list();
	}

	public Client findById(Integer id) {
		return clientBusinessObject.findById(id);
	}

	public Client registerNewClient(Client product) {
		return clientBusinessObject.registerNewClient(product);
	}

	public Client update(Client product) {
		return clientBusinessObject.update(product);
	}

}
