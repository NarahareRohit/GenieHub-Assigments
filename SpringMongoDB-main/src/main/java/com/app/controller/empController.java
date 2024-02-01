package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Emp;
import com.app.services.empServices;

@RestController
@RequestMapping("/emp")
public class empController {

	@Autowired
	private empServices empservice;
	
	@GetMapping("/")
	public ResponseEntity<List<Emp>> getAllEmp(){
		return ResponseEntity.status(HttpStatus.OK).body(empservice.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Emp> addEmp(@RequestBody Emp emp){
		Emp newEmp =empservice.postEmp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(newEmp);
	}
	
	@GetMapping("/{id}")
	public Emp getById(@PathVariable String id){
		Emp newEmp = empservice.getbyID(id);
		return newEmp;
	}
	
	@PutMapping("/{id}")
	public Emp updateEmp(@RequestBody Emp emp,@PathVariable String id) {
		return empservice.updateEmp(id,emp);
	}
	
	
}
