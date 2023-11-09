package edu.arquetipo.apiJava.daos;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.arquetipo.apiJava.dtos.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// Este método no hace falta que lo implementemos porque la convención de nombres
	// de consulta establece que si el nombre del método comienza con "findBy", spring buscará
	// automáticamente una propiedad en la entidad con el mismo nombre que sigue a "findBy".
//	public Optional<Usuario> findByDni(String dni);
//	
//	public Usuario deleteByDni(String dni);
}