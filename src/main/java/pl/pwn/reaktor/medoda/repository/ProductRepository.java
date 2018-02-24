/**
 * 
 */
package pl.pwn.reaktor.medoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.pwn.reaktor.medoda.model.Product;


/**
 * @author user
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
}
