package com.management.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
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
	
	@Modifying
	@Transactional
	@Query("UPDATE User u SET u.verified = ?1 WHERE u.email = ?2")
	void updateVerification(boolean verification, String email);
	
//	 @Modifying
//	 @Transactional
//	 @NativeQuery("UPDATE hr.user_table SET otp = ?1 WHERE email = ?2")
//	 void updateOtp(int otp, String email);
	
	@Modifying
	@Transactional
	@NativeQuery("UPDATE hr.user_table SET name = ?1, role = ?2, gender = ?3 WHERE id = ?4")
	void updateUser(String name, String role, String gender, Long id);
	
	@Modifying
	@Transactional
	@NativeQuery("UPDATE hr.user_table SET password = ?1 WHERE id = ?2")
	void updatePassword(String newPassword, Long id);

	
//	@Modifying
//	@Transactional
//	@Query("UPDATE User u SET u.verification = :verification WHERE u.email = :email")
//	void updateVerification(@Param("verification") boolean verification, @Param("email") String email); 
}
