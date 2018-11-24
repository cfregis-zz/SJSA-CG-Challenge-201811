package br.com.cast.challenge.products.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.bussinessobject.ProductBusinessObject;
import br.com.cast.challenge.products.model.Product;

@Component
public class ProductFacade {

	@Autowired
	private ProductBusinessObject productBusinessObject;
	
	public List<Product> list() {
		return productBusinessObject.list();
	}

	public Product findById(Integer id) {
		return productBusinessObject.findById(id);
	}

	public Product registerNewProduct(Product product) {
		return productBusinessObject.registerNewProduct(product);
	}

	public Product update(Product product) {
		return productBusinessObject.update(product);
	}

}
