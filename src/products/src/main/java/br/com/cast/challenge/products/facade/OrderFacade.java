package br.com.cast.challenge.products.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.bussinessobject.InvoiceBusinessObject;
import br.com.cast.challenge.products.model.Invoice;

@Component
public class OrderFacade {

	@Autowired
	private InvoiceBusinessObject invoiceBusinessObject;
	
	public List<Invoice> list() {
		return invoiceBusinessObject.list();
	}

	public Invoice findById(Integer id) {
		return invoiceBusinessObject.findById(id);
	}

	public Invoice registerNewInvoice(Invoice product) {
		return invoiceBusinessObject.registerNewInvoice(product);
	}

	public Invoice update(Invoice product) {
		return invoiceBusinessObject.update(product);
	}

}
