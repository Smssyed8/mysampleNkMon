package com.mindfulqatar.jobportal.services;

import java.io.FileNotFoundException;

import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

public interface FileService {
	void writeFile(MultipartFile imageFile, String fileAbsolutePath);

	String readDocFile(String fileName);

	String readDocxFile(String fileName);

	void writePdfFile(String output, String fileAbsolutePath) throws DocumentException, FileNotFoundException;
}