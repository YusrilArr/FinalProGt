package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Anggotakeluarga;

public interface IAnggotakeluargaRepo {
	public Anggotakeluarga insertAnggota(Anggotakeluarga anggotakeluarga);
	public List<Anggotakeluarga> getAllAnggota();
	public Anggotakeluarga updateAnggota(int id, Anggotakeluarga anggotakeluarga);
	public Anggotakeluarga deleteAnggota(int id);
	public Anggotakeluarga getAnggotaById(int id);
	public List<Anggotakeluarga> getAnggotaByIdKK(String id_kk);
	public Anggotakeluarga updateAnggotaById(int id, Anggotakeluarga anggotakeluarga);
	

}
