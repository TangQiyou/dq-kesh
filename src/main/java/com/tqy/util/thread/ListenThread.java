package com.tqy.util.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenThread extends Thread {
	
	public void run(){
		while(!this.isInterrupted()){
			try{
				Thread.sleep(20000);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(new Date());
			System.out.println("当前时间："+time);
		}
	}
}
