package pl.pwn.reaktor.medoda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pwn.reaktor.medoda.model.Product;
import pl.pwn.reaktor.medoda.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> listAllProducts() {

		return productRepository.findAll();
	}

	public Product findById(long id) {

		return productRepository.findOne(id);
	}
	
	
	public Product editProduct(Product product) {

		return productRepository.save(product);
	}
	
	
	
}
