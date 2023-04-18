package apiforreactapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiforreactapp.model.Visilean;
import apiforreactapp.repo.VisileanRepo;

@Service
public class VisileanService {

	@Autowired
	private VisileanRepo repo;
	
	public Visilean save(Visilean obj)
	{
	  return repo.save(obj);
	}
	

	public List<Visilean> get()
	{
	  return repo.findAll();
	}
	
	
	
	
}
