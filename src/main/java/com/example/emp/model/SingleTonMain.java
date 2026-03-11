package com.example.emp.model;

public class SingleTonMain{
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		 Runnable task = () -> {
	            SingleTon obj = SingleTon.getInstance();
	            System.out.println(Thread.currentThread().getName() + " : " + obj.hashCode());
	        };

	        Thread t1 = new Thread(task, "Thread-1");
	        Thread t2 = new Thread(task, "Thread-2");

	        t1.start();
	        t2.start();
		
//	SingleTon si=SingleTon.getInstance();
//	SingleTon s2 = (SingleTon)si.clone();
//	//SingleTon s2=SingleTon.getInstance();
//	System.out.println(si.hashCode());
//	System.out.println(s2.hashCode());
//	System.out.println(si.equals(s2));
	
	
	}

}
