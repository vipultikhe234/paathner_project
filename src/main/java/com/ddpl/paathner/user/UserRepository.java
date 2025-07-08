package com.ddpl.paathner.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmailIgnoreCase(String email);
}
