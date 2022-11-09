package br.com.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caps.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
