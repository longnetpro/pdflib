package info.longnetpro.pdflib.pdf;

public interface PdfObjectType {
	public static final int BOOLEAN = 1;
	public static final int NUMBER = 2;
	public static final int STRING = 3;
	public static final int NAME = 4;
	public static final int ARRAY = 5;
	public static final int DICTIONARY = 6;
	public static final int STREAM = 7;
	public static final int NULL = 8;
	public static final int INDIRECT_OBJECT = 10;
	public static final int INDIRECT_REFERENCE = 11;

	public static final String EMPTY_STRING = "";
}
