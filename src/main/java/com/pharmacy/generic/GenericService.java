package com.pharmacy.generic;

import java.util.List;

public interface GenericService<T extends Object> {

	T save(T entity);
    
    T update(T entity);
  
    void delete(T entity);
  
    default void delete(Long id) {};
    
    void deleteInBatch(List<T> entities);
  
    default T find(Long id) {
		return null;};
  
    List<T> findAll();
}
