package info.longnetpro.pdflib.pdf;

public class PdfIndirectObject extends PdfObject {

	public PdfIndirectObject() {
		super(PdfObjectType.INDIRECT_OBJECT);
	}

	public PdfIndirectObject(byte[] bytes) {
		super(PdfObjectType.INDIRECT_OBJECT, bytes);
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

	@Override
	public void parseBytes(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void convertToBytes() {
		// TODO Auto-generated method stub
		
	}
}
