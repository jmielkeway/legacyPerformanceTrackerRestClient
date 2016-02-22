package com.lis.investmentdataclient.document;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

public class PdfImageUnitTest {

	PdfImage image;
	
	@Before
	public void setUp() throws Exception {
		String path = "img/LisLogo.png";
		image = new PdfImage(path, 60, 60);
	}
	
	@Test
	public void shouldHaveCorrectImageLocation() throws Exception {
		URL url = image.getImageUrl();
		System.out.println(url);
		String expectedPath = "img/LisLogo.png";
		String actualPath = url.getPath();
		assertTrue(actualPath.contains(expectedPath));
	}
	
	
	@Test
	public void shouldHaveCorrectHeightAndLengthAttributes() throws Exception {
		assertEquals(60, image.getPercentageHeight());
		assertEquals(60, image.getPercentageWidth());
	}

}
