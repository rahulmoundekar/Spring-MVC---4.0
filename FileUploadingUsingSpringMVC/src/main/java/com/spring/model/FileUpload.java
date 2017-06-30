package com.spring.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {

	private String fileName;
	
	private CommonsMultipartFile[] fileup;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public CommonsMultipartFile[] getFileup() {
		return fileup;
	}
	public void setFileup(CommonsMultipartFile[] fileup) {
		this.fileup = fileup;
	}


	
}
