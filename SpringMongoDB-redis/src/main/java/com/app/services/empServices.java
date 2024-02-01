package com.app.services;

import java.util.List;

import com.app.entity.Emp;

public interface empServices {
	List<Emp> getAll();
	Emp postEmp(Emp emp);
	Emp getbyID(String id);
	Emp updateEmp(String id, Emp emp); 
}
