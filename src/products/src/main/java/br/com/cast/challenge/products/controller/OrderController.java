package br.com.cast.challenge.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cast.challenge.products.facade.ClientFacade;
import br.com.cast.challenge.products.facade.OrderFacade;
import br.com.cast.challenge.products.facade.ProductFacade;
import br.com.cast.challenge.products.model.Client;
import br.com.cast.challenge.products.model.Invoice;
import br.com.cast.challenge.products.model.Product;

@Controller
public class OrderController {
	
	@Autowired
	private OrderFacade orderFacade;
	
	@Autowired
	private ClientFacade clientFacade;
	
	@Autowired
	private ProductFacade productFacade;

	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String list(Model model){
		List<Invoice> listInvoices = orderFacade.list();
		model.addAttribute("orders", listInvoices);
		System.out.println("Returning rpoducts:");
		return "orders";
	}

	@RequestMapping("order/{id}")
	public String showInvoice(@PathVariable Integer id, Model model){
		model.addAttribute("order", orderFacade.findById(id));
		List<Product> listProducts = productFacade.list();
	    model.addAttribute("products", listProducts);
	    List<Client> listClients = clientFacade.list();
	    model.addAttribute("clients", listClients);
		return "ordershow";
	}

	@RequestMapping("order/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		model.addAttribute("order", orderFacade.findById(id));
		List<Product> listProducts = productFacade.list();
	    model.addAttribute("products", listProducts);
	    List<Client> listClients = clientFacade.list();
	    model.addAttribute("clients", listClients);
		return "orderform";
	}

	@RequestMapping("order/new")
	public String newInvoice(Model model){
		model.addAttribute("order", new Invoice());
		List<Product> listProducts = productFacade.list();
	    model.addAttribute("products", listProducts);
	    List<Client> listClients = clientFacade.list();
	    model.addAttribute("clients", listClients);
		
		return "orderform";
	}

	@RequestMapping(value = "order", method = RequestMethod.POST)
	public String saveInvoice(Invoice order){

		orderFacade.registerNewInvoice(order);

		return "redirect:/order/" + order.getId();
	}
}
