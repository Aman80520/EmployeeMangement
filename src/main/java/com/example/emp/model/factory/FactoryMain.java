package com.example.emp.model.factory;

public class FactoryMain {
	public static void main(String[] args) {
		
		
		ImmuatableUser iu=new ImmuatableUser(1,"Aman");
		ImmuatableUser iu1=new ImmuatableUser(1,"Sandeep");
		System.out.println(iu.getId());
		System.out.println(iu1.getName());
		ShapFactory shp=new ShapFactory();
		
		
		Shape s1=shp.createfac("cirle");
		// s1=shp.shapefactory("cirle");
		Shape s2=shp.createfac("trianglE");
		s1.shape();
		s2.shape();
			

	}

}
