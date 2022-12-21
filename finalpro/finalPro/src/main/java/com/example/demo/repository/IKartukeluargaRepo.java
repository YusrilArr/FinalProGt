package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Kartukeluarga;



public interface IKartukeluargaRepo {
	public Kartukeluarga insertKartu(Kartukeluarga kartukeluarga);
	public List<Kartukeluarga> getAllKartu();
	public Kartukeluarga updateKartu(int id, Kartukeluarga kartukeluarga);
	public Kartukeluarga deleteKartu(int id);
	public Kartukeluarga getKK(int id);

}
