package br.com.cast.challenge.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cast.challenge.products.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}

