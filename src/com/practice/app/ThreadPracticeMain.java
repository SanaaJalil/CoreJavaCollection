package com.practice.app;

/**
 * @author Sanaa
 * we can assign the implementing class to the interface as we assign child to parents in inheritance
 * what is start method? 
 * what is join method?
 * what is race condition?
 * what is deadlock?
 * what is run?
 * in this example below there is race condition because we are not getting 
 * the correct value so what needs to be done to correct the race condition?
 * we need to give for a thread a lock so that it can lock the value so other 
 * threads will not compete with the resource
 * race condition happen when we write not when we read
 * 2022
 */
public class ThreadPracticeMain {
	public static void main(String [] args){
		System.out.println("This is main threadand my name is "+Thread.currentThread().getName());
		Runnable runnable=new PracticeRunnable();
		Thread myThread=new Thread(runnable);
		myThread.setName("sanaa-thread");
		System.out.println("Now i am running and my name is "+myThread.getName());
		
		myThread.start();
		Runnable runnable2=new ThreadNumbersSum();
		Thread myThread2=new Thread(runnable2);
		myThread2.setName("sahar-thread");
		System.out.println("Now iam running and my name is "+ myThread2.getName());
		myThread2.start();
		LongWrapper longWrapper=new LongWrapper(0L);
		Runnable runnable3=()->{
			for(int i=0;i<1000;i++) {
				longWrapper.incrementNum();
			}
		};
		Thread myThread3=new Thread(runnable3);
		myThread3.setName("Haile-thread");
		myThread3.start();
		try {
			myThread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread[] threads=new Thread[1000];
		for(int v=0;v<threads.length;v++) {
			Thread myThread4=new Thread(runnable3);
			threads[v]=myThread4;
			threads[v].start();
			
		}
		for(int v=0;v<threads.length;v++) {
		//	Thread myThread4=new Thread(runnable3);
		//	threads[v]=myThread4;
			try {
				threads[v].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(longWrapper.getNum());

	}
	

}
