package br.com.cast.challenge;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.cast.challenge.ProductsApplication;
import br.com.cast.challenge.products.facade.ClientFacade;
import br.com.cast.challenge.products.facade.OrderFacade;
import br.com.cast.challenge.products.facade.ProductFacade;
import br.com.cast.challenge.products.model.Address;
import br.com.cast.challenge.products.model.Client;
import br.com.cast.challenge.products.model.Invoice;
import br.com.cast.challenge.products.model.Product;

/**
 * 
 * @author Carlos Filipe
 * Unit Tests
 */
@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = ProductsApplication.class)
public class ProductsApplicationTests {

	@Autowired
	protected ProductFacade productFacade;
	
	@Autowired
	private OrderFacade orderFacade;
	
	@Autowired
	private ClientFacade clientFacade;
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void testProductInsertion1() {
		Product p1 = new Product();
		p1.setDescription("book");
		p1.setCode("0001");
		p1.setPrice(new BigDecimal("10.00"));
		p1 = productFacade.registerNewProduct(p1);
		assertNotNull(p1);
		assertTrue(p1.getId() > 0);
	}
	
	
	@Test
	public void testProductInsertion2() {
		Product p2 = new Product();
		p2.setDescription("bike");
		p2.setPrice(new BigDecimal("100.00"));
		p2.setCode("0002");
		p2 = this.productFacade.registerNewProduct(p2);
		assertNotNull(p2);
		assertTrue(p2.getId() > 0);
	}
	
	@Test
	public void testClientInsertion1() {
		Client c1 = new Client();
		c1.setName("Maria");
		c1.setCpf("076.810.634-63");
		c1.setMail("test1@gmail.com");
		Address address = new Address();
		address.setCity("Recife");
		address.setClient(c1);
		address.setPostalCode("50810040");
		address.setProvince("PE");
		address.setStreet("Rua torres homem");
		
		c1.setAddress(address);
		c1 = clientFacade.registerNewClient(c1);
		assertNotNull(c1);
		assertTrue(c1.getId() > 0);
	}
	
	@Test
	public void testOrderInsertion1() {
		Client c1 = new Client();
		c1.setName("Jose");
		c1.setCpf("076.810.000-63");
		c1.setMail("test2@gmail.com");
		Address address = new Address();
		address.setCity("Recife");
		address.setClient(c1);
		address.setPostalCode("50810040");
		address.setProvince("PE");
		address.setStreet("Rua torres homem");
		
		c1.setAddress(address);
		c1 = clientFacade.registerNewClient(c1);
		assertNotNull(c1);
		assertTrue(c1.getId() > 0);
		
		Product p1 = new Product();
		p1.setDescription("book");
		p1.setCode("0001");
		p1.setPrice(new BigDecimal("10.00"));
		p1 = productFacade.registerNewProduct(p1);
		assertNotNull(p1);
		assertTrue(p1.getId() > 0);
		
		Product p2 = new Product();
		p2.setDescription("bike");
		p2.setPrice(new BigDecimal("100.00"));
		p2.setCode("0002");
		p2 = this.productFacade.registerNewProduct(p2);
		assertNotNull(p2);
		assertTrue(p2.getId() > 0);
	
		Invoice invoice =  new Invoice();
		invoice.setClient(c1);
		invoice.getItems().add(p1);
		invoice.getItems().add(p2);
		
		invoice = this.orderFacade.registerNewInvoice(invoice);
		
		assertNotNull(invoice);
		assertTrue(invoice.getId() > 0);
		
	}
}

