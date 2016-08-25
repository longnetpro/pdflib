package info.longnetpro.pdflib.document;

public class Page {
	private float width;
	private float height;
	private float userUnitMultiplier = 1.0f;

	public Page(float width, float height, float multiplier) {
		super();
		this.width = width;
		this.height = height;
		this.userUnitMultiplier = multiplier;
	}

	public Page(float width, float height) {
		super();
		this.width = width;
		this.height = height;
		this.userUnitMultiplier = 1.0f;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getWidth() {
		return width;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setUserUnitMultiplier(float userUnitMultiplier) {
		this.userUnitMultiplier = userUnitMultiplier;
	}

	public float getUserUnitMultiplier() {
		return userUnitMultiplier;
	}

	public ContentBox getPageCanvas() {
		return new ContentBox(0f, 0f, getWidth(), getHeight());
	}

	public ContentBox margin(Float[] margins) { // left, bottom, right, top
		float llx = 0f;
		float lly = 0f;
		float urx = getWidth();
		float ury = getHeight();
		int length = margins.length;
		if (length >= 1) {
			if (margins[0] != null) { // left
				llx += margins[0].floatValue();
			}
		}
		if (length >= 2) {
			if (margins[1] != null) { // bottom
				lly += margins[1].floatValue();
			}
		}
		if (length >= 3) {
			if (margins[2] != null) { // right
				urx -= margins[2].floatValue();
			}
		}
		if (length >= 4) {
			if (margins[3] != null) { // top
				ury -= margins[3].floatValue();
			}
		}

		ContentBox box = new ContentBox(llx, lly, urx, ury);
		return box;
	}
}
