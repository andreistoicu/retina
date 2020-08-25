package com.nypd.dataset.retinatest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nypd.dataset.retinatest.entity.Historic;
import com.nypd.dataset.retinatest.repository.HistoricRepository;

@Service
public class HistoricServiceImpl implements HistoricService {
	
	private HistoricRepository historicRepository;
	
	@Autowired
	public HistoricServiceImpl(HistoricRepository theHistoricRepository) {
		historicRepository = theHistoricRepository;
	}
	
	
	@Override
	public List<Historic> findAll() {
		return historicRepository.findAll();
	}

	@Override
	public Historic findById(int theId) {
		Optional<Historic> result = historicRepository.findById(theId);
		
		Historic historic = null;
		if(result.isPresent()) {
			historic = result.get();
		} else {
			//no historic line 
			throw new RuntimeException("Did not find any historic line with id - " + theId);
		}
		return historic;
	}

	@Override
	public void save(Historic theHistoric) {
		historicRepository.save(theHistoric);
	}

	@Override
	public void deleteById(int theId) {
		historicRepository.deleteById(theId);				
	}

	@Override
	public List<?> groupCountByKyCd() {
		return historicRepository.groupCountByKyCd();
	}

}
