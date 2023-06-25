package com.works.restjpa.repositories;

import com.works.restjpa.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}