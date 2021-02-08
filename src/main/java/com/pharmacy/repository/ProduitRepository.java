/**
 * 
 */
package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.bean.Produit;

/**
 * @author KALLO MOHAMED
 *
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

	Produit findByCode(Long code);
	
	List<Produit> findByCodeFam(String codeFam);
}
