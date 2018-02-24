/**
 * 
 */
package pl.pwn.reaktor.medoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.pwn.reaktor.medoda.model.Role;

/**
 * @author user
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
