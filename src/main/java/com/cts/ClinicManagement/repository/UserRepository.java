package com.cts.ClinicManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {

    // Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNumber(Long phoneNumber);

    // Optional<User> findByEmailOrPhoneNumber(String email, Long phoneNumber);

    boolean existsByPhoneNumber(Long phoneNumber);

    // boolean existsByEmail(String email);

}
