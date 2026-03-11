package com.example.emp.model.factory;

public final class ImmuatableUser{
	
	private final int id ;
	private final String name;
	
	
	public ImmuatableUser(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}


}
