package info.longnetpro.pdflib.pdf;

public final class PdfNull extends PdfObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final PdfNull NULL = new PdfNull();

	private PdfNull() {
		super(PdfObjectType.NULL);
		convertToBytes();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PdfNull) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void parseBytes(byte[] bytes) {
	}

	@Override
	public void convertToBytes() {
		this.bytes = toString().getBytes();
	}

	public String toString() {
		return "null";
	}
}
