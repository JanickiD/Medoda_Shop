package pl.pwn.reaktor.medoda.service;

<<<<<<< HEAD
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
	
	
=======
import org.springframework.stereotype.Service;

@Service
public class ProductService {
>>>>>>> 9523c338be9a74060ca811512853c4641d60a174
	

}
