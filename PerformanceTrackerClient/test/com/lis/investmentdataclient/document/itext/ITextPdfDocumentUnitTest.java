package com.lis.investmentdataclient.document.itext;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.document.PdfDocument;
import com.lis.investmentdataclient.document.PdfElement;
import com.lis.investmentdataclient.document.PdfParagraph;
import com.lis.investmentdataclient.document.itext.ITextPdfDocument;

public class ITextPdfDocumentUnitTest {
	
	PdfDocument document;
	
	@Before
	public void setUp() throws Exception {
		document = new ITextPdfDocument("test");
		document.open();
	}
	
	@Test
	public void shouldAddElementToDocument() throws Exception {
		PdfElement paragraph = new PdfParagraph("Welcome!");
		assertTrue(document.add(paragraph));
	}
	
	
	@Test
	public void shouldAddNewPageToDocument() throws Exception {
		document.add(new PdfParagraph("Hello!"));
		document.addPage();
		assertEquals(2, document.getNumberOfPages());
	}
	
	
	@Test
	public void shouldNotAddNewPageToDocumentDueToNoNewInformationOnPage() throws Exception {
		document.add(new PdfParagraph("Bye"));
		document.addPage();
		document.addPage();
		assertEquals(2, document.getNumberOfPages());
	}
	
	
	@After
	public void tearDown() throws Exception {
		document.close();
	}
}
