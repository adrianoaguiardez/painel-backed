package br.com.simconsult.painel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.simconsult.painel.modelo.Role;
import br.com.simconsult.painel.modelo.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM TBUSUARIO u WHERE email = ?1 AND password = ?2 ")
	public Optional<Usuario> login(String email, String password);

	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE TBUSUARIO SET role = ?2 WHERE id = ?1")
	public int updateRole(Long id, Role role);
	
	public Optional<Usuario> findByEmail(String email);

}
