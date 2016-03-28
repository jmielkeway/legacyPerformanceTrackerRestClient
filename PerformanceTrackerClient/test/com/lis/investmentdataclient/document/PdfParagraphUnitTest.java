package com.lis.investmentdataclient.document;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lis.investmentdataclient.document.itext.Alignment;
import com.lis.investmentdataclient.drawingtools.colorbased.DefaultFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public class PdfParagraphUnitTest {
	
	PdfParagraph paragraph;
	
	@Before
	public void setUp() throws Exception {
		paragraph = new PdfParagraph("Welcome to Legacy");
	}
	
	@Test
	public void shouldHaveCorrectFont() throws Exception {
		Font expectedFont = new DefaultFont();
		Font actualFont = paragraph.getFont();
		assertEquals(expectedFont, actualFont);
	}
	
	@Test
	public void shouldHaveCorrectAlignment() throws Exception {
		Alignment expectedAlignment = Alignment.LEFT;
		Alignment actualAlignment = paragraph.getAlignment();
		assertEquals(expectedAlignment, actualAlignment);
	}
}
