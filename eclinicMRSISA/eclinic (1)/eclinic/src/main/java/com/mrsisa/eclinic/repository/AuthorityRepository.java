package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}
