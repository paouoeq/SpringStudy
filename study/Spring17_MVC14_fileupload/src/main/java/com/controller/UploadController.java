package com.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.UploadDTO;

@Controller
public class UploadController {
	
	// 업로드할 화면
	@GetMapping("/uploadForm")
	public String uploadForm() {
		
		return "uploadForm";
	}
	
	// 업로드
	@PostMapping("/upload")
	public String upload(UploadDTO dto) {
		// 업로드 버튼 누르면 DTO에 자동 저장됨
		String theText = dto.getTheText();
		CommonsMultipartFile theFile = dto.getTheFile();
		
		// 파일 정보 얻기
		long size = theFile.getSize();
		String name = theFile.getName(); // 태그 이름
		String originalFilename = theFile.getOriginalFilename(); // 진짜 파일 이름
		String contentType = theFile.getContentType();
		
		// 정보 출력
		System.out.println(theText);
		System.out.println(size);
		System.out.println(name);
		System.out.println(originalFilename);
		System.out.println(contentType);
		
		File f = new File("c:\\upload", originalFilename); // 파일 저장 경로 지정
		
		try {
			theFile.transferTo(f); // 예외처리 필요(Surround with try/catch 클릭)
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "uploadForm";
	}
}
