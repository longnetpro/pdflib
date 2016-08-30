package info.longnetpro.pdflib.pdf;

public class PdfIndirectReference extends PdfObject {
	private static final long serialVersionUID = 1L;
	private int objectNumber;
	private int generation;

	public PdfIndirectReference(int objectNumber, int generation) {
		super(PdfObjectType.INDIRECT_REFERENCE);
		this.objectNumber = objectNumber;
		this.generation = generation;
	}

	public int getObjectNumber() {
		return objectNumber;
	}

	public void setObjectNumber(int objectNumber) {
		this.objectNumber = objectNumber;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

}
