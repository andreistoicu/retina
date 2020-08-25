package com.nypd.dataset.retinatest.service;

import java.util.List;

import com.nypd.dataset.retinatest.entity.Historic;

public interface HistoricService {
	
	public List<Historic> findAll();
	
	public Historic findById(int theId);
	
	public void save(Historic theHistoric);
	
	public void deleteById(int theId);
	
	public List<?> groupCountByKyCd();
	
}
