/*
 * Name: Michael Frake
 * Project: CMSC 3 Project 1
 * Date: Feb 28, 2022
 * Description: 
 */
package main;

public class Parser {
	MessageMeta[] messages;
	
	public class MessageMeta {
		private String recipient;
		private String theMessage;
	}
	
	public Parser() {
		
	}
	
	private MessageMeta[] populateMessages() {
		return messages;
	}
}
