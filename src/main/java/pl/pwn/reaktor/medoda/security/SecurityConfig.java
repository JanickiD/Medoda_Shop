/**
 * 
 */
package pl.pwn.reaktor.medoda.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author user
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery("SELECT email, pass FROM user where email=?")
			.authoritiesByUsernameQuery("SELECT u.email, r.role FROM user u inner join role r on r.role_id = u.id where u.email=?")
			.dataSource(dataSource)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/admin/*").hasAuthority("Admin")
		.antMatchers("/users/*").hasAnyAuthority("User", "Admin")
		.antMatchers("/moderator/*").hasAnyAuthority("Moderator")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}


	




