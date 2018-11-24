package br.com.cast.challenge.products.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cast.challenge.products.model.Client;

public interface ClientRepository extends PagingAndSortingRepository<Client, Integer> {

}

