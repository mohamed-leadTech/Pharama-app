package com.pharmacy.service;

import java.util.List;

import com.pharmacy.bean.Produit;
import com.pharmacy.generic.GenericService;

public interface ProduitService extends GenericService<Produit> {

	Produit findByCode(Long code);

	List<Produit> findByCodeFam(String codeFam);

}
