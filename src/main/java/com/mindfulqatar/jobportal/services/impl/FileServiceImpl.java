package com.mindfulqatar.jobportal.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mindfulqatar.jobportal.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public void writeFile(MultipartFile imageFile, String fileAbsolutePath) {
		if (!imageFile.isEmpty()) {
			try {
				// Get the file and save it somewhere
				byte[] bytes = imageFile.getBytes();
				Path path = Paths.get(System.getProperty("user.dir") + fileAbsolutePath);
				Files.write(path, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String readDocFile(String fileAbsolutePath) {
		String output = "";
		try {
			// File file = new File(fileAbsolutePath);
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + fileAbsolutePath);
			HWPFDocument doc = new HWPFDocument(fis);
			WordExtractor we = new WordExtractor(doc);
			String[] paragraphs = we.getParagraphText();
			for (String para : paragraphs) {
				output = output + "\n" + para.toString() + "\n";
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public String readDocxFile(String fileAbsolutePath) {
		String output = "";
		try {
			// File file = new File(fileAbsolutePath);
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + fileAbsolutePath);
			XWPFDocument document = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphs = document.getParagraphs();
			for (XWPFParagraph para : paragraphs) {
				output = output + "\n" + para.getText() + "\n";
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	@Override
	public void writePdfFile(String output, String fileAbsolutePath) throws DocumentException, FileNotFoundException {
		File file = new File(System.getProperty("user.dir") + fileAbsolutePath);
		FileOutputStream fileout = new FileOutputStream(file);
		Document document = new Document();
		PdfWriter.getInstance(document, fileout);
		document.addAuthor("Mindful Qatar");
		document.addTitle("Converted PDF");
		document.open();
		String[] splitter = output.split("\\n");
		for (int i = 0; i < splitter.length; i++) {
			Chunk chunk = new Chunk(splitter[i]);
			document.add(chunk);
			Paragraph paragraph = new Paragraph();
			paragraph.add("");
			document.add(paragraph);
		}
		document.close();
	}

}
