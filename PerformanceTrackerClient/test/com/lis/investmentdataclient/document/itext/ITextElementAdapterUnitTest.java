package com.lis.investmentdataclient.document.itext;

import static org.junit.Assert.*;


import org.junit.Test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.lis.investmentdataclient.document.PdfLine;

public class ITextElementAdapterUnitTest {
	
	@Test
	public void shouldHaveCorrectLineProperties() throws Exception {
		PdfLine line = new PdfLine(80);
		Paragraph iTextParagraph = (Paragraph) ITextElementAdapter.getITextElement(line);
		LineSeparator iTextLine = (LineSeparator) iTextParagraph.get(0);
		assertEquals(80, iTextLine.getPercentage(), 0.0001);
		assertEquals(16.5, iTextParagraph.getSpacingAfter(), 0.0001);
		assertEquals(BaseColor.BLACK, iTextLine.getLineColor());
	}
}
