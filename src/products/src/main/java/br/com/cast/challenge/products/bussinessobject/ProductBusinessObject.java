package br.com.cast.challenge.products.bussinessobject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cast.challenge.products.model.Product;
import br.com.cast.challenge.products.repository.ProductRepository;

@Component
public class ProductBusinessObject {
	
	@Autowired
	private ProductRepository productRepository;


	public List<Product> list() {
		return (List<Product>) productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).get();
	}

	public Product registerNewProduct(Product product) {
		return productRepository.save(product);
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}


}
