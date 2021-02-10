package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.bean.FamilleProduit;

@Repository
public interface FamilleProduitRepository extends JpaRepository<FamilleProduit, Long>{

}
