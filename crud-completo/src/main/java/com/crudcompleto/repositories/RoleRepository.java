package com.crudcompleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudcompleto.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
