package com.alzahraa.money.manegment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alzahraa.money.manegment.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    Optional<UserEntity> findByUsername(@Param("username") String username);


	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM UserEntity u WHERE u.username = :username")
	boolean existsByUsernameCustom(@Param("username") String username);
}