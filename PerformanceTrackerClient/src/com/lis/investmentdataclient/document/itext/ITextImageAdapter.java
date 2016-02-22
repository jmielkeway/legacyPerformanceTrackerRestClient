package com.lis.investmentdataclient.document.itext;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.lis.investmentdataclient.document.PdfImage;

public class ITextImageAdapter {

	public static Image getITextImage(PdfImage image) {
		try {
			URL url = image.getImageUrl();
			float percentY = image.getPercentageHeight();
			float percentX = image.getPercentageWidth();
			Image iTextImage = Image.getInstance(url);
			iTextImage.scalePercent(percentX, percentY);
			return iTextImage;
		} catch (BadElementException e) {
			throw new RuntimeException();
		} catch (MalformedURLException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
