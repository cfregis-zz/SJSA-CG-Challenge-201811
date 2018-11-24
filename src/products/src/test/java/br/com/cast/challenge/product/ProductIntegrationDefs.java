package br.com.cast.challenge.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.cast.challenge.ProductsApplication;
import br.com.cast.challenge.general.helper.CreationHelper;
import br.com.cast.challenge.general.helper.DeletionHelper;
import br.com.cast.challenge.products.facade.ProductFacade;

@ContextConfiguration()
@SpringBootTest(classes = ProductsApplication.class)
public abstract class ProductIntegrationDefs {

	@Autowired
	protected CreationHelper creation;
	
	@Autowired
	protected DeletionHelper deletion;
	
	@Autowired
	protected ProductFacade productFacade;
	
}
