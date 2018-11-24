package br.com.cast.challenge.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cast.challenge.products.facade.ProductFacade;
import br.com.cast.challenge.products.model.Product;

@Controller
public class ProductsController {
	
	private ProductFacade productService;

	@Autowired
	public void setProductService(ProductFacade productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String list(Model model){
		List<Product> listProducts = productService.list();
		model.addAttribute("products", listProducts);
		System.out.println("Returning rpoducts:");
		return "products";
	}

	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model){
		model.addAttribute("product", productService.findById(id));
		return "productshow";
	}

	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		model.addAttribute("product", productService.findById(id));
		return "productform";
	}

	@RequestMapping("product/new")
	public String newProduct(Model model){
		model.addAttribute("product", new Product());
		return "productform";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product){
		productService.registerNewProduct(product);
		return "redirect:/product/" + product.getId();
	}
}
