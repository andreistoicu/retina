package com.nypd.dataset.retinatest.rest;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nypd.dataset.retinatest.entity.Historic;
import com.nypd.dataset.retinatest.service.HistoricService;

@RestController
@RequestMapping("/dataset")
public class HistoricController {

	private HistoricService historicService;

	@Autowired
	public HistoricController(HistoricService theHistoricService) {
		historicService = theHistoricService;
	}
	
	//not mandatory in the test
	@GetMapping("/stats")
	public List<Historic> findAll() {
		return historicService.findAll();
	}
	

	@SuppressWarnings("unchecked")
	@GetMapping("/stats/total")
	public JSONObject countTotalEvents() throws JsonMappingException, JsonProcessingException {
		int totalEvents = (int) historicService.findAll().stream().count();
		JSONObject obj = new JSONObject();
		obj.put("totalEventsNumber", totalEvents);
		return obj;
	}
	
	@GetMapping("/stats/offenses")
	public List<?> groupByField() {
		return historicService.groupCountByKyCd();
	}

	@DeleteMapping("/{id}")
	public String deleteHistoricLine(@PathVariable int id) {
		Historic historicLine = historicService.findById(id);
		if (historicLine == null) {
			throw new RuntimeException("failed to delete historic line , not found id - " + id);
		}
		historicService.deleteById(id); 
		return "Succesfully deleted historyLine id - " + id;
	}
	
	
	 @PostMapping("") 
	 public Historic addHistoricCmplNumAndKyCd(@RequestBody Historic theHistoricCmplNumAndKyCd) {
		 theHistoricCmplNumAndKyCd.setId(0);
	  	 historicService.save(theHistoricCmplNumAndKyCd);
		 return theHistoricCmplNumAndKyCd; 
	 }
	 

}
