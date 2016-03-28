package com.lis.investmentdataclient.document;

public interface ElementVisitor {
	
	public void visit(PdfParagraph paragraph);

	public void visit(PdfImage image);
	
	public void visit(PdfLine line);

	public void visit(PdfTable table);

}
