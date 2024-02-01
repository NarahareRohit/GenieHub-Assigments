package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name ="username" , unique = true)
	private String userName;
	
	@Column(name = "email" , unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
}
