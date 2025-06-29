package com.management.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.management.app.model.User;

@Repository
public interface UserIRepo extends JpaRepository<User, Long>{
	
	
	List<User> findByEmail(String email);
	
	List<User> findByEmailAndOtp(String email, int otp);
	
//	 @Modifying
//	 @Transactional
//	 @Query(value = "UPDATE hr.user_table SET otp = ?1 WHERE email = ?2", nativeQuery = true)
//	 void updateOtp(int otp, String email);
	  
//	 @Modifying
//	 @Transactional
//	 @NativeQuery(value = "UPDATE hr.user_table SET otp = ?1 WHERE email = ?2")
//	 void updateOtp(int otp, String email);
	
//	 @Modifying
//	 @Transactional
//	 @NativeQuery("UPDATE hr.user_table SET otp = ?1 WHERE email = ?2")
//	 void updateOtp(int otp, String email);
	
//	 @Modifying
//	 @Transactional
//	 @NativeQuery(value = "UPDATE hr.user_table SET otp = :otp WHERE email = :email")
//	 void updateOtp(@Param("otp") int otp, @Param("email") String email); 
	
//	 @Modifying
//	 @Transactional
//	 @Query(value = "UPDATE User u SET u.otp = ?1 WHERE u.email = ?2")
//	 void updateOtp(int otp, String email);
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE User u SET u.otp = ?1 WHERE u.email = ?2")
//	void updateOtp(int otp, String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.otp = :otp WHERE u.email = :email")
	void updateOtp(@Param("otp") int otp, @Param("email") String email); 
	
	
}
