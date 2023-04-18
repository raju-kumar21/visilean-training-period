package demofortesting.demofortesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demofortesting.demofortesting.model.Visilean;
import demofortesting.demofortesting.repo.VisileanRepo;


@Service
public class VisileanService {


	private VisileanRepo repo;

	public VisileanService(VisileanRepo repo) {
		this.repo = repo;
	}

	
	
	public Visilean save(Visilean obj)
	{
	  return repo.save(obj);
	}

	public List<Visilean> get() {
		
		return repo.findAll();
	}

	public Visilean get(Integer id) {
		
		return repo.findById(id).get();
	}
	
	
	public void delete(Integer id) {
		
		repo.deleteById(id);
	}

	public Visilean update(Integer id,   Visilean obj) {
		Visilean ob=repo.findById(id).get();
//		ob.setId(obj.getId());
		ob.setTeam(obj.getTeam());
		ob.setLocation(obj.getLocation());
		return repo.save(ob);
	}
	
	
	
}
