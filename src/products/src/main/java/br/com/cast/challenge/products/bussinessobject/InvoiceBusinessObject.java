package br.com.cast.challenge.products.bussinessobject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.model.Invoice;
import br.com.cast.challenge.products.repository.InvoiceRepository;
import br.com.cast.challenge.products.util.Util;

@Component
public class InvoiceBusinessObject {
	
	@Autowired
	private InvoiceRepository orderRepository;


	public List<Invoice> list() {
		return (List<Invoice>) orderRepository.findAll();
	}

	public Invoice findById(Integer id) {
		return orderRepository.findById(id).get();
	}

	public Invoice registerNewInvoice(Invoice order) {
		Long nextCodeLong = orderRepository.getMaxId();
		nextCodeLong++;
		order.setSerial(Util.completeChar(nextCodeLong.toString(), '0', Util.INICIO, 6));
		return orderRepository.save(order);
	}

	public Invoice update(Invoice order) {
		return orderRepository.save(order);
	}

	
}
