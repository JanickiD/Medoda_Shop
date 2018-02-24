package pl.pwn.reaktor.medoda.service;

<<<<<<< HEAD
=======

>>>>>>> 07f659998ec11a911d50308de07c78c09b74eaf8
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
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 07f659998ec11a911d50308de07c78c09b74eaf8
