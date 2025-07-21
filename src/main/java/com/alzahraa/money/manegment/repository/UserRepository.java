package com.alzahraa.money.manegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alzahraa.money.manegment.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
