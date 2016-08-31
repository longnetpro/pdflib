package info.longnetpro.pdflib.pdf;

public class PdfBoolean extends PdfObject {
	private static final long serialVersionUID = 1L;

	private boolean value = false;

	public PdfBoolean() {
		super(PdfObjectType.BOOLEAN);
	}

	public PdfBoolean(byte[] bytes) {
		super(PdfObjectType.BOOLEAN, bytes);
	}

	@Override
	public void parseBytes(byte[] bytes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToBytes() {
		this.bytes = toString().getBytes();
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String toString() {
		return value ? "true" : "false";
	}

}
