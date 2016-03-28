package com.lis.investmentdataclient.document.itext;

import java.util.EnumMap;
import java.util.Map;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.lis.investmentdataclient.document.PdfParagraph;

public class ITextParagraphAdapter {
	
	private static Map<Alignment, Integer> alignmentMap = new EnumMap<Alignment, Integer>(Alignment.class);
	static {
		alignmentMap.put(Alignment.LEFT, Element.ALIGN_LEFT);
		alignmentMap.put(Alignment.CENTER, Element.ALIGN_CENTER);
		alignmentMap.put(Alignment.RIGHT, Element.ALIGN_RIGHT);
	}

	public static Paragraph getITextParagraph(PdfParagraph element) {
		Font font = ITextFontAdapter.getFont(element.getFont());
		float spacing = (float) element.getTrailingSpacing();
		int alignment = alignmentMap.get(element.getAlignment());
		Paragraph paragraph = new Paragraph(element.getParagraphContent(), font);
		paragraph.setAlignment(alignment);
		paragraph.setSpacingAfter(spacing);
		return paragraph;
	}

}
