package com.example.emp.model;

public class SingleTon implements Cloneable{
	
	private static SingleTon instance;
	
	private SingleTon() {}
	public  static synchronized SingleTon getInstance() {
		if (instance==null) {
		    synchronized (SingleTon.class) {
		    	if(instance==null) {
					instance=new SingleTon();
				}
			}
		}
		
		return instance;
		
	}
	 @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return new CloneNotSupportedException("Singleton cannot be cloned"); // This will break singleton!
	    }


}
