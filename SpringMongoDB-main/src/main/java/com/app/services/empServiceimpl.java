package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Emp;
import com.app.repository.EmpRepo;


@Service
public class empServiceimpl implements empServices{
	
	@Autowired
	private  EmpRepo empRepo;

	@Override
	public List<Emp> getAll() {
		return empRepo.findAll();
	}

	@Override
	public Emp postEmp(Emp emp) {
		return empRepo.save(emp);
	}

	@Override
	public Emp getbyID(String id) {
		return empRepo.findById(id).orElse(null);
	}

	@Override
	public Emp updateEmp(String id,Emp emp) {
		return empRepo.save(emp);
	}

}
