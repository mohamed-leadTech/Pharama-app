package com.pharmacy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.bean.FamilleProduit;
import com.pharmacy.repository.FamilleProduitRepository;
import com.pharmacy.service.FamilleProduitService;

@Service
public class FamilleProduitServiceImpl implements FamilleProduitService{

	@Autowired
	private FamilleProduitRepository familleProduitRepository;
	
	@Override
	public FamilleProduit save(FamilleProduit entity) {
		return familleProduitRepository.save(entity);
	}

	@Override
	public FamilleProduit update(FamilleProduit entity) {
		return familleProduitRepository.save(entity);
	}

	@Override
	public void delete(FamilleProduit entity) {
		familleProduitRepository.delete(entity);
		
	}
    
	@Override
	public void delete(Long codeFam) {
		familleProduitRepository.delete(codeFam);		
	}

	@Override
	public void deleteInBatch(List<FamilleProduit> entities) {
		familleProduitRepository.deleteInBatch(entities);		
	}

    @Override
	public FamilleProduit find(Long code) {
		return familleProduitRepository.findOne(code);
	}

	@Override
	public List<FamilleProduit> findAll() {
		return familleProduitRepository.findAll();
	}

}
