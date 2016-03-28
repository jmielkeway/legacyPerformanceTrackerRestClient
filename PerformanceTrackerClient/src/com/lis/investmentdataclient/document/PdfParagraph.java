package com.lis.investmentdataclient.document;

import com.lis.investmentdataclient.document.itext.Alignment;
import com.lis.investmentdataclient.drawingtools.colorbased.DefaultFont;
import com.lis.investmentdataclient.drawingtools.colorbased.Font;

public class PdfParagraph implements PdfElement {
	
	private String paragraphContent;
	private double trailingSpacing;
	private Font font;
	private Alignment alignment;
	
	public PdfParagraph(String content) {
		setParagraphContent(content);
		setTrailingSpacing(16.5);
		font = new DefaultFont();
		alignment = Alignment.LEFT;
	}
	
	
	public PdfParagraph(String content, Font font) {
		this(content);
		this.font = font;
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
		return font;
	}
	

	public Alignment getAlignment() {
		return alignment;
	}
	
	
	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
}
