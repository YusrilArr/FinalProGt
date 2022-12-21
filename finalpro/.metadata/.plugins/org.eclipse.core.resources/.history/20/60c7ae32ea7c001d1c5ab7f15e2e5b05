package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Anggotakeluarga;
import com.example.demo.service.IAnggotaService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/anggota")
public class AnggotaController {
	
	@Autowired
	IAnggotaService anggotaService;
	
	@PostMapping("/insert_anggota")
	public Anggotakeluarga insertAnggota(@RequestBody Anggotakeluarga anggotakeluarga) {
		return anggotaService.insertAnggota(anggotakeluarga);
	}
	
	@GetMapping("/getAllAnggota")
	public List<Anggotakeluarga> getAllAnggota(){
		return anggotaService.getAllAnggota();
	}
	
	@PutMapping("/update_anggota/{id}")
	public Anggotakeluarga updateAnggota(@PathVariable int id, @RequestBody Anggotakeluarga anggotakeluarga) {
		return anggotaService.updateAnggota(id, anggotakeluarga);
	}
	
	@DeleteMapping("/delete_anggota/{id}")
	public Anggotakeluarga deleteAnggota(@PathVariable int id) {
		return anggotaService.deleteAnggota(id);
	}

}
