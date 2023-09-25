package com.exam.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	String theText;
	MultipartFile theFile;
	public UploadDTO() {
		// TODO Auto-generated constructor stub
	}
	public UploadDTO(String theText, MultipartFile theFile) {
		this.theText = theText;
		this.theFile = theFile;
	}
	public String getTheText() {
		return theText;
	}
	public void setTheText(String theText) {
		this.theText = theText;
	}
	public MultipartFile getTheFile() {
		return theFile;
	}
	public void setTheFile(MultipartFile theFile) {
		this.theFile = theFile;
	}
	@Override
	public String toString() {
		return "UploadDTO [theText=" + theText + ", theFile=" + theFile + "]";
	}
	
	
}
