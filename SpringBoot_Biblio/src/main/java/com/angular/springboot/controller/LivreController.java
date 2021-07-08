package com.angular.springboot.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.exception.ResourceNotFoundException;
import com.angular.springboot.model.Livre;
import com.angular.springboot.repository.LivreRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class LivreController {
	@Autowired
	private LivreRepository livreRepository;

	@GetMapping("/livres")
	public List<Livre> getAllLivre() {
		return livreRepository.findAll();
	}

	@GetMapping("/livres/{id}")
	public ResponseEntity<Livre> getLivreById(@PathVariable(value = "id") Long livreIsbn)
			throws ResourceNotFoundException {
		Livre livre = livreRepository.findById(livreIsbn)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + livreIsbn));
		return ResponseEntity.ok().body(livre);
	}

	@PostMapping("/livres")
	public  Livre addLivre( @RequestBody Livre livre, Livre aa )   {
		//System.out.println("Test"+livre.getadddate()+livre.getTitre()+livre.getIsbn()+"   valeur: "+aa);
boolean livrecheck =livreRepository.findById(livre.getIsbn()).isPresent(); 
		if (!livrecheck  )
		return livreRepository.save(livre); 
		else
			System.out.println("Livre deja existant");
		return livre ;
		
		
		//Map<String, Boolean> response = new HashMap<>();
		//response.put("Livre deja existant", Boolean.TRUE);
		//return response;
	
	}

	@PutMapping("/livres/{id}")
	public ResponseEntity<Livre> updateLivre(@PathVariable(value = "id") Long livreId,
			@Valid @RequestBody Livre livreDetails) throws ResourceNotFoundException {
		Livre livre = livreRepository.findById(livreId)
				.orElseThrow(() -> new ResourceNotFoundException("Livre not found for this id :: " + livreId));


		livre.setTitre(livreDetails.getTitre());
		final Livre updatedComenntaire = livreRepository.save(livre);
		return ResponseEntity.ok(updatedComenntaire);
	}

	@DeleteMapping("/livres/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long livreisbn)
			throws ResourceNotFoundException {
		Livre livre = livreRepository.findById(livreisbn)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + livreisbn));

		livreRepository.delete(livre);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	
	
	
	
}
