package com.lis.investmentdataclient.document.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.lis.investmentdataclient.document.ElementVisitor;
import com.lis.investmentdataclient.document.PdfElement;
import com.lis.investmentdataclient.document.PdfImage;
import com.lis.investmentdataclient.document.PdfLine;
import com.lis.investmentdataclient.document.PdfParagraph;
import com.lis.investmentdataclient.document.PdfTable;

public class ITextElementAdapter implements ElementVisitor {
	
	Element iTextElement;

	public static Element getITextElement(PdfElement element) {
		ITextElementAdapter adapter = new ITextElementAdapter();
		element.accept(adapter);
		return adapter.iTextElement;
	}

	
	@Override
	public void visit(PdfParagraph element) {
		iTextElement = ITextParagraphAdapter.getITextParagraph(element);
	}


	@Override
	public void visit(PdfImage image) {
		iTextElement = ITextImageAdapter.getITextImage(image);
	}


	@Override
	public void visit(PdfLine line) {
		float lineWidth = (float) line.getWidthPercentage();
		float spacingAfter = (float) line.getTrailingSpacing();
		LineSeparator iTextLine = new LineSeparator(1, lineWidth, BaseColor.BLACK, Element.ALIGN_CENTER, -5);
		Paragraph paragraph = new Paragraph();
		paragraph.add(iTextLine);
		paragraph.setSpacingAfter(spacingAfter);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		iTextElement = paragraph;
	}


	@Override
	public void visit(PdfTable table) {
		iTextElement = ITextTableAdapter.getITextTable(table);
	}
	
	

}
