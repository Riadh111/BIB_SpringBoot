package com.angular.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.angular.springboot.model.Livre;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long>{

}
