package info.longnetpro.pdflib.pdf;

public class PdfNumber extends PdfObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isInt = true;
	private long integer = 0;
	private double real = 0d;

	public PdfNumber() {
		super(PdfObjectType.NUMBER);
		// TODO Auto-generated constructor stub
	}

	public PdfNumber(byte[] bytes) {
		super(PdfObjectType.NUMBER, bytes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseBytes(byte[] bytes) {
		// TODO Auto-generated method stub

	}

	public boolean isInteger() {
		return isInt;
	}

	public long longValue() {
		if (isInt) {
			return integer;
		} else {
			return Math.round(real);
		}
	}

	public int intValue() {
		return (int) longValue();
	}

	public double realValue() {
		if (isInt) {
			return (double) integer;
		} else {
			return real;
		}
	}

	public void setNumber(int integer) {
		this.isInt = true;
		this.integer = integer;
	}

	public void setNumber(double real) {
		this.isInt = false;
		this.real = real;
	}

	@Override
	public void convertToBytes() {
		String number = "";
		if (isInt) {
			number = Integer.toString(intValue());
		} else {
			number = Double.toString(realValue());
		}
		bytes = number.getBytes();
	}

}
