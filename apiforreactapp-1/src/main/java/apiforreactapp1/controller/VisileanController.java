package apiforreactapp1.controller;

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

import apiforreactapp1.model.Visilean;
import apiforreactapp1.service.VisileanService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/visilean")

public class VisileanController {

	@Autowired
	private VisileanService service;
	
	@PostMapping("/save")
	@ApiOperation(value = "store visilean data api ")
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
