package hh.backend.hotel_booking.web;



import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;





@Configuration  
@EnableMethodSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
http
.csrf(csrf -> csrf.disable())
		 .authorizeHttpRequests(authorize -> authorize
                
                .requestMatchers("/roomlist", "/roomlist/**", "/listhotel/**","/bookerlist/**", "/booked/**", "/api/**","/comerlist/**","/login/**").permitAll()
                .requestMatchers("/addroom", "/deleteroom/**", "/updateroom/**", "/saveroom", "/roomupdate").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
		.formLogin(formlogin -> formlogin
			.defaultSuccessUrl("/listhotel", true)
			.permitAll()
			
		)
		.logout(logout -> logout
			.permitAll()
		);	
		return http.build();
	}

	@Bean
		public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder()
			.username("admin")
			.password(passwordEncoder().encode("admin"))
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(userDetails);
	}
	
	@Bean 
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}