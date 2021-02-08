package com.pharmacy.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="code_fam")
	private String codeFam;
	
	@Column(name="nom_fam")
	private String nomFam;

	public String getCodeFam() {
		return codeFam;
	}

	public void setCodeFam(String codeFam) {
		this.codeFam = codeFam;
	}

	public String getNomFam() {
		return nomFam;
	}

	public void setNomFam(String nomFam) {
		this.nomFam = nomFam;
	}

	@Override
	public String toString() {
		return "FamilleProduit [codeFam=" + codeFam + ", nomFam=" + nomFam + "]";
	}
	
	

}
