package com.practice.app;

/**
 * @author Sanaa
 *
 * 2022
 */
public class ThreadNumbersSum implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int number=0;
		for(int i=0;i<1001;i++) {
		 number+=i;
		}
		System.out.println(number);

	}

}
