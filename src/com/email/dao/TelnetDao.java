package com.email.dao;

import com.jscape.inet.telnet.*;

import java.io.*;

public class TelnetDao extends TelnetAdapter {
	private Telnet telnet = null;
	private OutputStream output = null;
	private static BufferedReader reader = null;
	private boolean connected = false;
	
	public TelnetDao(String hostname, String username, String password) 
	    throws IOException, TelnetException {
		String input = null;
		
		telnet = new Telnet(hostname);
		telnet.setPort(4555);
		
		telnet.addTelnetListener(this);
		
		try {
			telnet.connect();
			connected = true;
		} catch (Exception e) {
			System.out.println("Exception occured when connet telnet");
			e.printStackTrace();
		}
		
		output = telnet.getOutputStream();
		
		String serverLogin = "root";
		String serverPassword = "root";
		
		input = "adduser " + username + " " + password;
		
		if (connected) {
			((TelnetOutputStream) output).println(serverLogin);
			int command = telnet.TSC_CR;
			
			((TelnetOutputStream) output).println(serverPassword);
			command = telnet.TSC_CR;
			
			((TelnetOutputStream) output).println(input);
			System.out.println("james 用户增加成功");
		} else {
			System.out.println("james 用户增加失败");
		}
		
		telnet.disconnect();	
	}

}
