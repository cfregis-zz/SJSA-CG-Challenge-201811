package br.com.cast.challenge.general.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.challenge.products.model.Product;
import br.com.cast.challenge.products.repository.ProductRepository;

@Component
public class CreationHelper {
	
	@Autowired
	public ProductRepository productRepository;
	
	@Transactional
	public Product createProduct(Product product) {
		productRepository.save(product);
		return product;
	}
	
	
}
