package info.longnetpro.pdflib.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfTest {

	private final static String ROOT = "C:\\temp\\pdftest\\";

	public static void main(String[] args) throws IOException {
		testPdfNull();
		testPdfBoolean();
		testPdfString();
		testPdfNumber();
	}

	private static void writeToFile(String fileName, byte[] bytes) throws IOException {
		String file = ROOT + fileName;
		System.out.println(bytes.length);
		FileOutputStream fs = new FileOutputStream(new File(file));
		fs.write(bytes);
		fs.close();
	}

	public static void testPdfNull() throws IOException {
		String fileName = "pdfnull.txt";
		PdfNull pdfObject = (PdfNull) PdfObjectType.PDF_NULL;
		writeToFile(fileName, pdfObject.getBytes());
	}

	public static void testPdfBoolean() throws IOException {
		String fileName = "pdfboolean.txt";
		PdfBoolean pdfObject = new PdfBoolean();
		pdfObject.setValue(true);
		pdfObject.convertToBytes();
		writeToFile(fileName, pdfObject.getBytes());
	}

	public static void testPdfString() throws IOException {
		String fileName = "pdfString.txt";
		PdfString pdfObject = new PdfString();
		pdfObject.setText("This is a test");
		pdfObject.convertToBytes();
		writeToFile(fileName, pdfObject.getBytes());
	}

	public static void testPdfNumber() throws IOException {
		String fileName = "pdfNumber.txt";
		PdfNumber pdfObject = new PdfNumber();
		pdfObject.setNumber(
				-123000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001.1d);
		System.out.println(pdfObject.isInteger());
		pdfObject.convertToBytes();
		writeToFile(fileName, pdfObject.getBytes());
	}

}
