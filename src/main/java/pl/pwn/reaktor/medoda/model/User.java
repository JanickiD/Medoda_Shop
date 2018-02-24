/**
 * 
 */
package pl.pwn.reaktor.medoda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import pl.pwn.reaktor.medoda.model.Role;

/**
 * @author user
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message="{pl.reaktor.notEmpty}")
	@Email(message="{pl.reaktor.email}")
	@Column(unique=true)
	private String email;
	

	@NotEmpty(message="{pl.reaktor.notEmpty}")
	@Length(min=5, message="{pl.reaktor.password.length}")
	private String pass;
	
	private boolean active;
	
	@NotEmpty(message="{pl.reaktor.notEmpty}")
	private String name;
	
	@NotEmpty(message="{pl.reaktor.notEmpty}")
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User(long id, String email, String pass, String name, String lastName, boolean active,Role role) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.role = role;
	}

	public User() {
		super();
	}

	public User(String email, String pass, String name, String lastName, boolean active, Role role) {
		super();
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.lastName = lastName;
		this.active = active;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pass=" + pass + ", name=" + name + ", lastName=" + lastName
				+ ", active=" + active + ", role=" + role + "]";
	}
	
	

}
