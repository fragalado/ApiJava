package edu.arquetipo.apiJava.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.arquetipo.apiJava.daos.Acceso;
import edu.arquetipo.apiJava.daos.AccesoRepository;
import edu.arquetipo.apiJava.daos.Usuario;
import edu.arquetipo.apiJava.daos.UsuarioRepository;
import edu.arquetipo.apiJava.utiles.ResourceNotFoundException;

// Definimos el controlador REST para Usuario
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AccesoRepository accesoRepository;
	
	@GetMapping
	public List<Usuario> obtenerUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario obtenerUsuarioPorId(@PathVariable Long id){
		return usuarioRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
	}
	
	@PostMapping
	public void crearUsuario(String nombreUsuario, String apellidosUsuario, String dniUsuario, String emailUsuario, String tlfUsuario, String claveUsuario) {
		// Creamos un usuario y lo devolvemos
		Acceso acc = accesoRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Acceso no encontrado"));
		usuarioRepository.save(new Usuario(dniUsuario, nombreUsuario, apellidosUsuario, tlfUsuario, emailUsuario, claveUsuario, false, null, null, null, acc));
	}
	
	@PutMapping("/{id}")
	public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
		Usuario usuario = usuarioRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
		usuario.setDni_usuario(usuarioActualizado.getDni_usuario());
		usuario.setNombre_usuario(usuarioActualizado.getNombre_usuario());
		usuario.setApellidos_usuario(usuarioActualizado.getApellidos_usuario());
		usuario.setTlf_usuario(usuarioActualizado.getTlf_usuario());
		usuario.setEmail_usuario(usuarioActualizado.getEmail_usuario());
		usuario.setClave_usuario(usuarioActualizado.getClave_usuario());
		usuario.setEstaBloqueado_usuario(usuarioActualizado.isEstaBloqueado_usuario());
		usuario.setFch_fin_bloqueo_usuario(usuarioActualizado.getFch_fin_bloqueo_usuario());
		usuario.setFch_alta_usuario(usuarioActualizado.getFch_alta_usuario());
		usuario.setFch_baja_usuario(usuarioActualizado.getFch_baja_usuario());
		
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	public void borrarUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
}