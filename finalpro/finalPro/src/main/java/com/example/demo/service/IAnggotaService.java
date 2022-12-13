package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Anggotakeluarga;


public interface IAnggotaService {
	public Anggotakeluarga insertAnggota(Anggotakeluarga anggotakeluarga);
	public List<Anggotakeluarga> getAllAnggota();
	public Anggotakeluarga updateAnggota(int id, Anggotakeluarga anggotakeluarga);
	public Anggotakeluarga deleteAnggota(int id);

}
