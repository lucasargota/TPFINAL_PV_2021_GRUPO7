package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.ITuristaDAO;

@Service
public class LoginTuristaServiceImp implements UserDetailsService {
	
	@Autowired
	ITuristaDAO turistaDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Turista turistaEncontrado = turistaDAO.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("cliente invalido"));
		
		System.out.print("aaaaaaaaaaaaaaaaaaaa");
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(turistaEncontrado.getPais());
		tipos.add(grantedAuthority);
		 
		
		
		
		System.out.print("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		UserDetails user = (UserDetails) new User(email, turistaEncontrado.getPassword(),tipos);
		
		
		
		
		return user;
	}
	
	
	
}
