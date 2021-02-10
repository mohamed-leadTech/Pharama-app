package com.pharmacy.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="famille_produit")
public class FamilleProduit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;
		
	@Column(name="nom_fam")
	private String nomFam;
	
	private String libelle;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomFam() {
		return nomFam;
	}

	public void setNomFam(String nomFam) {
		this.nomFam = nomFam;
	}

	@Override
	public String toString() {
		return "FamilleProduit [code=" + code + ", nomFam=" + nomFam + ", libelle=" + libelle + "]";
	}

	
	
	

}
