package info.longnetpro.pdflib.pdf;

public class PdfString extends PdfObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;

	public PdfString() {
		super(PdfObjectType.STRING);
		// TODO Auto-generated constructor stub
	}

	public PdfString(byte[] bytes) {
		super(PdfObjectType.STRING, bytes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseBytes(byte[] bytes) {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToBytes() {
		if (text != null) {
			bytes = text.getBytes();
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return text;
	}

}
