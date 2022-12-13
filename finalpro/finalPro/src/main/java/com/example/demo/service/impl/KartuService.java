package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Kartukeluarga;
import com.example.demo.repository.IKartukeluargaRepo;
import com.example.demo.service.IKartuService;

@Service
public class KartuService implements IKartuService {
	
	@Autowired
	IKartukeluargaRepo kartukeluargaRepo;

	@Override
	public Kartukeluarga insertKartu(Kartukeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		
		return kartukeluargaRepo.insertKartu(kartukeluarga);
	}

	@Override
	public List<Kartukeluarga> getAllKartu() {
		// TODO Auto-generated method stub
		return kartukeluargaRepo.getAllKartu();
	}

	@Override
	public Kartukeluarga updateKartu(int id, Kartukeluarga kartukeluarga) {
		// TODO Auto-generated method stub
		return kartukeluargaRepo.updateKartu(id, kartukeluarga);
	}

	@Override
	public Kartukeluarga deleteKartu(int id) {
		// TODO Auto-generated method stub
		
		return kartukeluargaRepo.deleteKartu(id);
	}

	

}
