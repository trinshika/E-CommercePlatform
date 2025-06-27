package com.management.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.app.model.User;

@Repository
public interface UserIRepo extends JpaRepository<User, Long>{
	List<User> findByEmail(String email);
	List<User> findByEmailAndOtp(String email, int otp);
}
