package apiforreactapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import apiforreactapp.model.Visilean;
import apiforreactapp.service.VisileanService;

@RestController
public class VisileanController {

	@Autowired
	private VisileanService service;
	
	@PostMapping("/save")
	public Visilean save(@RequestBody Visilean obj)
	{
		return service.save(obj);
	}

	@GetMapping("/get")
	public List<Visilean> get()
	{
		return service.get();
	}
	
	
	
	
}
