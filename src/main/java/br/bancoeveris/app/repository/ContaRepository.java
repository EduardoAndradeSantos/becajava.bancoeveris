package br.bancoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.bancoeveris.app.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findByHash(String hash);
	

}