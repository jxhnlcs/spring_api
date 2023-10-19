package br.john.restapi.db;

import org.springframework.data.jpa.repository.JpaRepository;

import br.john.restapi.model.Contato;

public interface ContatoDB extends JpaRepository<Contato, Long> {
  
}
