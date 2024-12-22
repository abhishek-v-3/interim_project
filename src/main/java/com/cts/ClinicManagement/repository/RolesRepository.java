package com.cts.ClinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.Roles;
import java.util.Optional;


public interface RolesRepository extends JpaRepository<Roles,Long>{

    Optional<Roles> findByRole(String role);
}
