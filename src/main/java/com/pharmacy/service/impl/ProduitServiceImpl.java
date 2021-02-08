package com.pharmacy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.bean.Produit;
import com.pharmacy.repository.ProduitRepository;
import com.pharmacy.service.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

	@Override
	public Produit save(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public Produit update(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public void delete(Produit produit) {
		produitRepository.delete(produit);
	}

	@Override
	public void delete(Long id) {
		produitRepository.delete(id);
	}

	@Override
	public void deleteInBatch(List<Produit> produits) {
		produitRepository.deleteInBatch(produits);
		;
	}

	@Override
	public Produit find(Long id) {
		return produitRepository.findByCode(id);
	}

	@Override
	public List<Produit> findAll() {
		return produitRepository.findAll();
	}

	@Override
	public Produit findByCode(Long code) {
		return produitRepository.findByCode(code);
	}

	@Override
	public List<Produit> findByCodeFam(String codeFam) {
		return produitRepository.findByCodeFam(codeFam);
	}

}
