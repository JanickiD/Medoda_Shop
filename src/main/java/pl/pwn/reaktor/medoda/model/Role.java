/**
 * 
 */
package pl.pwn.reaktor.medoda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author user
 *
 */
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long role_id;

	private String role;

	public long getId() {
		return role_id;
	}

	public void setId(long role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Role(long role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}

	public Role() {
		super();
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}

}
