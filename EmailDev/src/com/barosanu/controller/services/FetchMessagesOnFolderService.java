package com.barosanu.controller.services;

import javax.mail.Folder;
import javax.mail.Message;

import com.barosanu.model.folder.EmailFolderBean;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FetchMessagesOnFolderService extends Service<Void>{
	
	private EmailFolderBean<String> emailFolder;
	private Folder folder;
	public final int MAX_FOLDER_SIZE = 2000;
	
	
	public FetchMessagesOnFolderService(EmailFolderBean<String> emailFolder, Folder folder) {
		this.emailFolder = emailFolder;
		this.folder = folder;
	}


	@Override
	protected Task<Void> createTask() {
		return new Task<Void>(){
			@Override
			protected Void call() throws Exception {
				if(folder.getType() != Folder.HOLDS_FOLDERS){
					folder.open(Folder.READ_WRITE);
				}
				int folderSize = folder.getMessageCount();
				for(int i = folderSize; i > 0 ; i--){
					Message currentMessage = folder.getMessage(i);
					emailFolder.addEmail(currentMessage);
					}				
				return null;
			}			
		};
	}
	

}
