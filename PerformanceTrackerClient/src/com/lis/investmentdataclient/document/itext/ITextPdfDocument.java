package com.lis.investmentdataclient.document.itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.lis.investmentdataclient.document.PdfDocument;
import com.lis.investmentdataclient.document.PdfElement;
import com.lis.investmentdataclient.document.PdfPage;

public class ITextPdfDocument implements PdfDocument {
	
	Document document;
	String fileName;
	PdfWriter writer;
	
	
	protected ITextPdfDocument() {
		document = new Document(PageSize.LETTER.rotate(), 50, 50, 50, 50);
	}
	
	public ITextPdfDocument(String fileName) {
		this();
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void open() {
		document.open();
	}
	
	
	@Override
	public void close() {
		document.close();
	}

	
	@Override
	public boolean add(PdfElement element) {
		Element iTextElement = ITextElementAdapter.getITextElement(element);
		try {
			return document.add(iTextElement);
		} 
		catch (DocumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}
	}


	@Override
	public boolean addPage(PdfPage page) {
		boolean newPage = document.newPage();
		for(PdfElement p : page.getPdfElementsInPage())
			newPage = add(p);
		return newPage;
	}


	@Override
	public int getNumberOfPages() {
		return writer.getPageNumber();
	}
}
