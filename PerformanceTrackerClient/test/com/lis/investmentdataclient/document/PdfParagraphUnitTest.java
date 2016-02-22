package com.lis.investmentdataclient.document;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lis.investmentdataclient.drawingtools.colorbased.DefaultFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public class PdfParagraphUnitTest {
	
	@Test
	public void shouldHaveCorrectFont() throws Exception {
		PdfParagraph paragraph = new PdfParagraph("Welcome to Legacy!");
		Font expectedFont = new DefaultFont();
		Font actualFont = paragraph.getFont();
		assertEquals(expectedFont, actualFont);
	}

}
