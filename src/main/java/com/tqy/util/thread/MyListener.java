package com.tqy.util.thread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

		
	private ListenThread listenThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(listenThread != null && listenThread.isInterrupted()){
			listenThread.interrupt();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String str = null;
		if (str == null && listenThread == null){
			listenThread = new ListenThread();
			listenThread.start();
		}
	}

}
