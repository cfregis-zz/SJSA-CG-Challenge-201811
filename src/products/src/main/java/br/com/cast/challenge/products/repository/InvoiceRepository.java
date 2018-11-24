package br.com.cast.challenge.products.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.cast.challenge.products.model.Invoice;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer> {
	
	@Query("SELECT coalesce(max(i.id), 0) FROM Invoice i")
	Long getMaxId();

}

