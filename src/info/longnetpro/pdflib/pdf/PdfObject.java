package info.longnetpro.pdflib.pdf;

import java.io.Serializable;

public class PdfObject implements Serializable {
	public static final PdfObject PDF_NULL = PdfNull.NULL;

	private static final long serialVersionUID = 1L;

	protected int type;
	protected byte[] bytes;

	public PdfObject(int type) {
		this.type = type;
	}

	public PdfObject(int type, byte[] bytes) {
		this.type = type;
		this.bytes = bytes;
	}

	public boolean canBeInObjectStream() {
		switch (this.type) {
		case PdfObjectType.NULL:
		case PdfObjectType.BOOLEAN:
		case PdfObjectType.NUMBER:
		case PdfObjectType.STRING:
		case PdfObjectType.NAME:
		case PdfObjectType.ARRAY:
		case PdfObjectType.DICTIONARY:
		case PdfObjectType.INDIRECT_REFERENCE:
			return true;
		case PdfObjectType.STREAM:
		case PdfObjectType.INDIRECT_OBJECT:
		default:
			return false;
		}
	}

	public byte[] getBytes() {
		return bytes;
	}

	public int getType() {
		return type;
	}

	public boolean isArray() {
		return (type == PdfObjectType.ARRAY);
	}

	public boolean isBoolean() {
		return (type == PdfObjectType.BOOLEAN);
	}

	public boolean isDictionary() {
		return (type == PdfObjectType.DICTIONARY);
	}

	public boolean isIndirectObject() {
		return (type == PdfObjectType.INDIRECT_OBJECT);
	}

	public boolean isIndirectReference() {
		return (type == PdfObjectType.INDIRECT_REFERENCE);
	}

	public boolean isName() {
		return (type == PdfObjectType.NAME);
	}

	public boolean isNull() {
		return (type == PdfObjectType.NULL);
	}

	public boolean isNumber() {
		return (type == PdfObjectType.NUMBER);
	}

	public boolean isStream() {
		return (type == PdfObjectType.STREAM);
	}

	public boolean isString() {
		return (type == PdfObjectType.STRING);
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public String toString() {
		return super.toString();
	}

}
