package com.practice.app;

/**
 * @author Sanaa
 *
 * 2022
 */
public class LongWrapper {
	Object key=new Object();

	
	private long num;
	
	public LongWrapper(long num) {
		
		this.num=num;
	}
	public long getNum() {
		
		return num;
	}
	public void incrementNum() {
		synchronized(key){
			 num=num +1;

		}
				 
	}
}
