package com.lis.investmentdataclient.document.itext;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.document.PdfDocument;
import com.lis.investmentdataclient.document.PdfElement;
import com.lis.investmentdataclient.document.PdfParagraph;
import com.lis.investmentdataclient.document.custompages.LegacyPerformanceHeaderPage;
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
		document.addPage(new LegacyPerformanceHeaderPage());
		assertEquals(2, document.getNumberOfPages());
	}
	
	
	@Test
	public void shouldBeginWithNewPageToDocument() throws Exception {
		assertEquals(true, document.addPage(new LegacyPerformanceHeaderPage()));
	}
	
	
	@After
	public void tearDown() throws Exception {
		document.close();
	}
}
