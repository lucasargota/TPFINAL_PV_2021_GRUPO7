package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.service.imp.LoginTuristaServiceImp;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
			
		@Autowired
		private AutenticationHandler autenticacion;
		
		 String[] resources = new String[] {
				 
				 "/include/**","/css/**","/img/**","/js/**","/layer/**","/webjars/**"
		
		 };
		 
		 @Override
			protected void configure(HttpSecurity http) throws Exception{
			 http
			//Correccion	
				.requiresChannel()
			      .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
			      .requiresSecure()
			      .and()
			      //ojo
					.authorizeRequests()
						.antMatchers(resources).permitAll()
						.antMatchers("/","/home","/index","/turista/registrar","/turista/guardar").permitAll()
						.anyRequest().authenticated()
						.and()
					.formLogin()				
					.loginPage("/login").permitAll()
					.successHandler(autenticacion)
					.failureUrl("/login?error=true")
					.usernameParameter("correo")
					.passwordParameter("password")
					.and()
					.logout()
					.permitAll();
			 http.csrf().disable();
			 	
		 }
		 
		 @Bean
		    public BCryptPasswordEncoder passwordEncoder() {
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		        return bCryptPasswordEncoder;
		    }
	 	 @Autowired
		    LoginTuristaServiceImp userDetailsService;
		    
		    @Autowired
		    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {    
		    	
		    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		    	    }
		    
		 
	

}
