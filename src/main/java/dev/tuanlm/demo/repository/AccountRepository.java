package dev.tuanlm.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.tuanlm.demo.models.UserAccount;

@Repository
public interface AccountRepository extends JpaRepository<UserAccount, Integer> {
	
	UserAccount findByUsernameAndPassword(String username, String password);
	
	UserAccount findByUsername(String username);
}
