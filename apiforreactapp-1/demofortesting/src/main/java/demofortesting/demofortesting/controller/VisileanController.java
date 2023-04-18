package demofortesting.demofortesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demofortesting.demofortesting.model.Visilean;
import demofortesting.demofortesting.service.VisileanService;

@RestController
@CrossOrigin
@RequestMapping("/test")
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
	
	@GetMapping("/getById/{id}")
	public Visilean get(@PathVariable("id") Integer id)
	{
		return service.get(id);
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Integer id)
	{
		service.delete(id);
	}
	
	@PutMapping("/updateById/{id}")
	public Visilean updateById(@PathVariable("id") Integer id,@RequestBody Visilean obj)
	{
		
		return service.update(id,obj);
	}
	
	
}
