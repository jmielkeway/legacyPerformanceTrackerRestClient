package com.lis.investmentdataclient.document;

import com.lis.investmentdataclient.drawingtools.colorbased.DefaultFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public class PdfParagraph implements PdfElement {
	
	private String paragraphContent;
	private double trailingSpacing;

	
	public PdfParagraph(String content) {
		setParagraphContent(content);
		setTrailingSpacing(16.5);
	}

	
	protected void setParagraphContent(String content) {
		this.paragraphContent = content;
	}
	
	
	protected void setTrailingSpacing(double spacing) {
		this.trailingSpacing = spacing;
	}
	
	
	public String getParagraphContent() {
		return paragraphContent;
	}

	
	public double getTrailingSpacing() {
		return trailingSpacing;
	}
	
	@Override
	public void accept(ElementVisitor visitor) {
		visitor.visit(this);
	}

	
	public Font getFont() {
		return new DefaultFont();
	}
}
