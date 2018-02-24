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
	private String mail;
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
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserFilter(String name, String lastName, String mail) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
	}
	public UserFilter() {
		super();
	}
	@Override
	public String toString() {
		return "UserFilter [name=" + name + ", lastName=" + lastName + ", mail=" + mail + "]";
	}
	
}
