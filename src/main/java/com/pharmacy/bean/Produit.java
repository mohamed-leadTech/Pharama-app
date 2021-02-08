package com.pharmacy.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Produits")
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;

	private double prix;
	
	private String nomFab; // nom fabricant
	
	private LocalDate dateExp;
	
	private String libelle;
	
	private Long idStock;
	
	private String codeFam;
	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getnomFab() {
		return nomFab;
	}

	public void setnomFab(String nomFab) {
		this.nomFab = nomFab;
	}

	public LocalDate getDateExp() {
		return dateExp;
	}

	public void setDateExp(LocalDate dateExp) {
		this.dateExp = dateExp;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getIdStock() {
		return idStock;
	}

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public String getcodeFam() {
		return codeFam;
	}

	public void setcodeFam(String codeFam) {
		this.codeFam = codeFam;
	}
	
	@Override
	public String toString() {
		return "Produit [code=" + code + ", prix=" + prix + ", nomFab=" + nomFab + ", dateExp=" + dateExp
				+ ", libelle=" + libelle + ", idStock=" + idStock + ", codeFam=" + codeFam + "]";
	}
	
	
	
	

}
