/**
 * 
 */
package pl.pwn.reaktor.medoda.model;

/**
 * @author user
 *
 */

public class UserFilter {
	private String name;
	private String lastName;
	private String email;
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
	public String getMail() {
		return email;
	}
	public void setMail(String email) {
		this.email = email;
	}
	public UserFilter(String name, String lastName, String email) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	public UserFilter() {
		super();
	}
	@Override
	public String toString() {
		return "UserFilter [name=" + name + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
