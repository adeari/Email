package com.barosanu.controller;

import com.barosanu.model.EmailMessageBean;

public class ModelAccess {
	
	
	private EmailMessageBean selectedMessage;

	public EmailMessageBean getSelectedMessage() {
		return selectedMessage;
	}

	public void setSelectedMessage(EmailMessageBean selectedMessage) {
		this.selectedMessage = selectedMessage;
	}
	

}