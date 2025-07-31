package ma.ensaf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.formLogin(Customizer.withDefaults())
				.authorizeHttpRequests(req -> req
						.requestMatchers("/login/**").permitAll()
						.requestMatchers("/api/admin/**").hasAnyAuthority("ADMIN")
						.requestMatchers("/api/user/**").hasAnyAuthority("USER", "ADMIN")
						.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
						.requestMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
						.anyRequest().authenticated())
				.userDetailsService(userDetailsService)
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
