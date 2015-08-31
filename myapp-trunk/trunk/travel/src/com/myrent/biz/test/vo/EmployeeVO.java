package com.myrent.biz.test.vo;

import org.springframework.web.multipart.MultipartFile;

import com.myrent.data.model.vo.BaseVO;

public class EmployeeVO extends BaseVO{

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
