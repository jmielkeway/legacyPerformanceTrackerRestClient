package com.lis.investmentdataclient.document.itext;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.Image;
import com.lis.investmentdataclient.document.PdfImage;

public class ITextImageAdapterUnitTest {
	
	Image image;
	int heightPct = 25;
	int widthPct = 30;
	String path;
	
	@Before
	public void setUp() throws Exception {
		path = "img/LisLogo.png";
		PdfImage pdfImage = new PdfImage(path, heightPct, widthPct);
		image = ITextImageAdapter.getITextImage(pdfImage);
	}
	
	
	@Test
	public void shouldHaveCorrectHeightAndWidth() throws Exception {
		assertEquals(150.0, image.getScaledHeight(), 0.0001);
		assertEquals(360.0, image.getScaledWidth(), 0.0001);
	}
	
	
	@Test
	public void shouldHaveCorrectImageUrl() throws Exception {
		String urlString = path;
		assertTrue(image.getUrl().getPath().contains(urlString));
	}

}
