package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_kartu_keluarga")
public class Kartukeluarga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String alamat;
	private String desa_kelurahan;
	private String kabupaten_kota;
	private String kecamatan;
	private String kode_pos;
	
	@Column(unique = true)
	private String nomor_kk;
	
	private String provinsi;
	private String rt;
	private String rw;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getDesa_kelurahan() {
		return desa_kelurahan;
	}
	public void setDesa_kelurahan(String desa_kelurahan) {
		this.desa_kelurahan = desa_kelurahan;
	}
	public String getKabupaten_kota() {
		return kabupaten_kota;
	}
	public void setKabupaten_kota(String kabupaten_kota) {
		this.kabupaten_kota = kabupaten_kota;
	}
	public String getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}
	public String getKode_pos() {
		return kode_pos;
	}
	public void setKode_pos(String kode_pos) {
		this.kode_pos = kode_pos;
	}
	public String getNomor_kk() {
		return nomor_kk;
	}
	public void setNomor_kk(String nomor_kk) {
		this.nomor_kk = nomor_kk;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	
	

}
