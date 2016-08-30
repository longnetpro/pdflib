package info.longnetpro.pdflib.pdf;

public class PdfNull extends PdfObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final PdfNull NULL = new PdfNull();

	private PdfNull() {
		super(PdfObjectType.NULL);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PdfNull) {
			return true;
		} else {
			return false;
		}
	}

}
