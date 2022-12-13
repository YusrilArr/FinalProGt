package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Anggotakeluarga;
import com.example.demo.repository.IAnggotakeluargaRepo;

@Repository
public class AnggotakeluargaRepo implements IAnggotakeluargaRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Anggotakeluarga insertAnggota(Anggotakeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "INSERT  INTO tb_anggota_keluarga(agama, id_kk, jenis_kelamin, kepala_keluarga, nama, nik, pendidikan, tanggal_lahir, tempat_lahir)"
				+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(), 
				anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(), anggotakeluarga.getNik(), anggotakeluarga.getPendidikan(),
				anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir()});
		return anggotakeluarga;
	}

	@Override
	public List<Anggotakeluarga> getAllAnggota() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Anggotakeluarga.class));
	}

	@Override
	public Anggotakeluarga updateAnggota(int id, Anggotakeluarga anggotakeluarga) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_anggota_keluarga SET agama = ?, id_kk = ?, jenis_kelamin = ?, kepala_keluarga = ?, nama = ?, nik = ?, pendidikan = ?, tanggal_lahir = ?, tempat_lahir = ? WHERE id = ?";
		jdbcTemplate.update(query, new Object[] {anggotakeluarga.getAgama(), anggotakeluarga.getId_kk(), anggotakeluarga.getJenis_kelamin(), anggotakeluarga.getKepala_keluarga(), anggotakeluarga.getNama(),
				anggotakeluarga.getNik(), anggotakeluarga.getPendidikan(), anggotakeluarga.getTanggal_lahir(), anggotakeluarga.getTempat_lahir(), id});
		return anggotakeluarga;
	}

	@Override
	public Anggotakeluarga deleteAnggota(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_anggota_keluarga WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Anggotakeluarga.class), id);
		
		query = "DELETE FROM tb_anggota_keluarga WHERE id = ?";
		jdbcTemplate.update(query, id);
		return result;
	}

}
