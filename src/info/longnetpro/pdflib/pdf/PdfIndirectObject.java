package info.longnetpro.pdflib.pdf;

public class PdfIndirectObject extends PdfObject {

	public PdfIndirectObject() {
		super(PdfObjectType.INDIRECT_OBJECT);
	}

	private static final long serialVersionUID = 1L;

	private PdfIndirectReference indirectReference;
	private PdfObject pdfObject;

	public PdfIndirectReference getIndirectReference() {
		return indirectReference;
	}

	public void setIndirectReference(PdfIndirectReference indirectReference) {
		this.indirectReference = indirectReference;
	}

	public PdfObject getPdfObject() {
		return pdfObject;
	}

	public void setPdfObject(PdfObject pdfObject) {
		this.pdfObject = pdfObject;
	}
}
