package com.example.hello.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private Long id;
	private String name;
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
