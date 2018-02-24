/**
 * 
 */
package pl.pwn.reaktor.medoda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author user
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				return bCryptPasswordEncoder;	
	}

}