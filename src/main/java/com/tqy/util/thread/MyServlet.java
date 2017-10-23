package com.tqy.util.thread;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ListenThread listenThread;
	
	public MyServlet(){
		
	}
	
	public void init(){
		String str = null;
		if (str == null && listenThread == null){
			listenThread = new ListenThread();
			listenThread.start();
		}
	}
	
	
	public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse){

	}
	
	public void destory(){
        if (listenThread != null && listenThread.isInterrupted()) {  
        	listenThread.interrupt();  
        }  
	}
}