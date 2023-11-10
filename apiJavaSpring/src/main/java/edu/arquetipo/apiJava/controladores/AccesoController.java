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
import edu.arquetipo.apiJava.utiles.ResourceNotFoundException;

@RestController
@RequestMapping("/acceso")
public class AccesoController {

	@Autowired
	private AccesoRepository accesoRepository;

	@GetMapping
	public List<Acceso> obtenerAccesos() {
		return accesoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Acceso obtenerAccesoPorId(@PathVariable Long id) {
		return accesoRepository
				.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Acceso no encontrado"));
	}

	@PostMapping
	public Acceso crearAcceso(@RequestBody Acceso acceso) {
		return accesoRepository.save(acceso);
	}

	@PutMapping("/{id}")
	public Acceso actualizarAcceso(@PathVariable Long id, @RequestBody Acceso accesoActualizado) {
		Acceso acceso = accesoRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Acceso no encontrado"));
		
		acceso.setCodigo_acceso(accesoActualizado.getCodigo_acceso());
		acceso.setDescripcion_acceso(accesoActualizado.getDescripcion_acceso());
		
		return accesoRepository.save(acceso);
	}

	@DeleteMapping("/{id}")
	public void borrarAcceso(@PathVariable Long id) {
		accesoRepository.deleteById(id);
	}
}
