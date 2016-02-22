package com.lis.investmentdataclient.document.itext;

import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.lis.investmentdataclient.document.PdfParagraph;

public class ITextParagraphAdapter {

	public static Paragraph getITextParagraph(PdfParagraph element) {
		Font font = ITextFontAdapter.getFont(element.getFont());
		float spacing = (float) element.getTrailingSpacing();
		Paragraph paragraph = new Paragraph(element.getParagraphContent(), font);
		paragraph.setSpacingAfter(spacing);
		return paragraph;
	}

}
