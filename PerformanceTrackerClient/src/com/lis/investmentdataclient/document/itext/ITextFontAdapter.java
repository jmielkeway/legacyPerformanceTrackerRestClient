package com.lis.investmentdataclient.document.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

public class ITextFontAdapter {

	public static Font getFont(com.lis.investmentdataclient.drawingtools.colorbased.Font font) {
		int fontSize = font.getFontSize();
		int red = font.getRedChannel();
		int blue = font.getBlueChannel();
		int green = font.getGreenChannel();
		BaseColor color = new BaseColor(red, green, blue);
		Font iTextFont = new Font(FontFamily.HELVETICA, fontSize, Font.NORMAL, color);
		return iTextFont;
	}

}
