package com.example.emp.model.factory;

public class ShapFactory {
	public Shape createfac(String shape) {
		
		if(shape.equalsIgnoreCase("cirle")) {
			return new Circle();
		}else if(shape.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		}else {
			return null;
		}
	}

}
