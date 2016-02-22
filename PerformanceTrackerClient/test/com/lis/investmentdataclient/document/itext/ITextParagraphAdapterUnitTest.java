package com.lis.investmentdataclient.document.itext;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.lis.investmentdataclient.document.PdfParagraph;
import com.lis.investmentdataclient.drawingtools.colorbased.DefaultFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public class ITextParagraphAdapterUnitTest {
	
	Paragraph paragraph;
	String welcome;
	Font expectedFont;
	
	@Before
	public void setUp() throws Exception {
		welcome = "Welcome to Legacy!";
		PdfParagraph element = new PdfParagraph(welcome);
		paragraph = ITextParagraphAdapter.getITextParagraph(element);
		expectedFont = new DefaultFont();
	}
	
	
	@Test
	public void shouldHaveCorrectParagraphString() throws Exception {
		String expectedString = welcome;
		String actualString = paragraph.getContent();
		assertEquals(expectedString, actualString);
	}
	
	
	@Test
	public void shouldHaveCorrectFontColors() throws Exception {
		BaseColor testColor = paragraph.getFont().getColor();
		int expectedRed = expectedFont.getRedChannel();
		int actualRed = testColor.getRed();
		int expectedGreen = expectedFont.getGreenChannel();
		int actualGreen = testColor.getGreen();
		int expectedBlue = expectedFont.getBlueChannel();
		int actualBlue = testColor.getBlue();
		assertEquals(expectedRed, actualRed);
		assertEquals(expectedBlue, actualBlue);
		assertEquals(expectedGreen, actualGreen);
	}
	
	
	@Test
	public void shouldHaveCorrectFontSize() throws Exception {
		int expectedSize = expectedFont.getFontSize();
		int actualSize = (int) paragraph.getFont().getSize();
		assertEquals(expectedSize, actualSize);
	}
	
	
	@Test
	public void shouldHaveCorrectFontFamily() throws Exception {
		FontFamily expectedFamily = FontFamily.HELVETICA;
		FontFamily actualFamily = paragraph.getFont().getFamily();
		assertEquals(expectedFamily, actualFamily);
	}
	
	
	@Test
	public void shouldHaveCorrectFontStyle() throws Exception {
		int expectedStyle = com.itextpdf.text.Font.NORMAL;
		int actualStyle = paragraph.getFont().getStyle();
		assertEquals(expectedStyle, actualStyle);
	}
	
	
	@Test
	public void shouldHaveCorrectLeading() throws Exception {
		double expectedLeading = 16.5;
		double actualLeading = (double) paragraph.getLeading();
		assertEquals(expectedLeading, actualLeading, 0.00001);
	}
	
	
	@Test
	public void shouldHaveCorrectSpacingAfter() throws Exception {
		double expectedSpacingAfter = 16.5;
		double actualSpacingAfter = (double) paragraph.getSpacingAfter();
		assertEquals(expectedSpacingAfter, actualSpacingAfter, 0.0001);
	}

}
