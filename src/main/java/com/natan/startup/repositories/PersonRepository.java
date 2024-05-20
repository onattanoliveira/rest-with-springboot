package com.natan.startup.repositories;

import com.natan.startup.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Long> {}
