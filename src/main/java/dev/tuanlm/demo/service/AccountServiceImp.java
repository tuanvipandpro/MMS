package dev.tuanlm.demo.service;

import java.util.Collections;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.tuanlm.demo.models.UserAccount;
import dev.tuanlm.demo.repository.AccountRepository;
import dev.tuanlm.demo.request.LoginRequest;
import dev.tuanlm.demo.response.LoginResponse;
import dev.tuanlm.demo.utils.JwtUtils;

@Service
@Transactional
public class AccountServiceImp implements AccountService, UserDetailsService{
	
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public AccountServiceImp(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccount ua = Optional.of(accountRepository.findByUsername(username))
				.orElseThrow(()-> new UsernameNotFoundException(username + " is not exist !!!"));
		return new User(username, ua.getPassword(), Collections.emptyList());
	}

	@Override
	public LoginResponse getTokenByUsernameAndPassword(LoginRequest request) {		
		UserAccount ua = accountRepository.findByUsername(request.getUsername());
		return passwordEncoder.matches(request.getPassword(), ua.getPassword()) 
				? new LoginResponse(
						JwtUtils.generateJwtToken(request.getUsername()), 
						request.getUsername(), 
						ua.getArea().getId(),
						ua.getArea().getName(),
						ua.getArea().getDetails())
				: null;
	}

}
