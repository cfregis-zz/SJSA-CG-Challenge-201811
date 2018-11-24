package br.com.cast.challenge.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cast.challenge.products.facade.ClientFacade;
import br.com.cast.challenge.products.model.Client;

@Controller
public class ClientController {
	
	private ClientFacade clientService;

	@Autowired
	public void setClientService(ClientFacade clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String list(Model model){
		List<Client> listClients = clientService.list();
		model.addAttribute("clients", listClients);
		System.out.println("Returning rpoducts:");
		return "clients";
	}

	@RequestMapping("client/{id}")
	public String showClient(@PathVariable Integer id, Model model){
		model.addAttribute("client", clientService.findById(id));
//		List<ClientType> list = ClientType.getAllValues();
//	    model.addAttribute("clientTypes", list);
		return "clientshow";
	}

	@RequestMapping("client/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		model.addAttribute("client", clientService.findById(id));
//		List<ClientType> list = ClientType.getAllValues();
//	    model.addAttribute("clientTypes", list);
		return "clientform";
	}

	@RequestMapping("client/new")
	public String newClient(Model model){
		model.addAttribute("client", new Client());
//		List<ClientType> list = ClientType.getAllValues();
//	    model.addAttribute("clientTypes", list);
		
		return "clientform";
	}

	@RequestMapping(value = "client", method = RequestMethod.POST)
	public String saveClient(Client client){

		clientService.registerNewClient(client);

		return "redirect:/client/" + client.getId();
	}
}
