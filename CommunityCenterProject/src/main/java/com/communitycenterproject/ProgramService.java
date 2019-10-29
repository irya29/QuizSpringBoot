package com.communitycenterproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProgramService {
	@Autowired
	private ProgramRepository repo;
	
	public List<Program> listAll() {
		 return repo.findAll();
	}
	
	public void save(Program program) {
        repo.save(program);
    }
     
    public Program get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
