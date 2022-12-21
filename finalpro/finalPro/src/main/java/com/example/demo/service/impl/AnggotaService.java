package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Anggotakeluarga;
import com.example.demo.repository.IAnggotakeluargaRepo;
import com.example.demo.service.IAnggotaService;

@Service
public class AnggotaService implements IAnggotaService {
	
	@Autowired
	IAnggotakeluargaRepo anggotakeluargaRepo;

	@Override
	public Anggotakeluarga insertAnggota(Anggotakeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.insertAnggota(anggotakeluarga);
	}

	@Override
	public List<Anggotakeluarga> getAllAnggota() {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.getAllAnggota();
	}

	@Override
	public Anggotakeluarga updateAnggota(int id, Anggotakeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.updateAnggota(id, anggotakeluarga);
	}

	@Override
	public Anggotakeluarga deleteAnggota(int id) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.deleteAnggota(id);
	}


	@Override
	public Anggotakeluarga getAnggotaById(int id) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.getAnggotaById(id);
	}

	@Override
	public List<Anggotakeluarga> getAnggotaByIdKK(String id_kk) {
		// TODO Auto-generated method stub
		return anggotakeluargaRepo.getAnggotaByIdKK(id_kk);
	}

	

}
