package info.longnetpro.pdflib.document;

public enum Anchor {
	BOTTOM_LEFT(0f, 0f, 0f, 0f, 1f, 1f), LEFT(0f, 0.5f, 0f, -0.5f, 1f, 1f), TOP_LEFT(0f, 1f, 0f, -1f, 1f, -1f), TOP(
			0.5f, 1f, -0.5f, -1f, 1f,
			-1f), TOP_RIGHT(1f, 1f, -1f, -1f, -1f, -1f), RIGHT(1f, 0.5f, -1f, -0.5f, -1f, 1f), BOTTOM_RIGHT(1f, 0f, -1f,
					0f, -1f, 1f), BOTTOM(0.5f, 0f, -0.5f, 0f, 1f, 1f), CENTER(0.5f, 0.5f, -0.5f, -0.5f, 1f, 1f);
	private static final long serialVersionUID = 1L;

	private final float containerXFactor;
	private final float containerYFactor;
	private final float elementXFactor;
	private final float elementYFactor;
	private final float offsetXFactor;
	private final float offsetYFactor;

	Anchor(float pageXFactor, float pageYFactor, float elementXFactor, float elementYFactor, float offsetXFactor,
			float offsetYFactor) {
		this.containerXFactor = pageXFactor;
		this.containerYFactor = pageYFactor;
		this.elementXFactor = elementXFactor;
		this.elementYFactor = elementYFactor;
		this.offsetXFactor = offsetXFactor;
		this.offsetYFactor = offsetYFactor;
	}

	public ContentBox anchorElement(ContentBox contentBox, float width, float height, float offsetX, float offsetY) {
		float cw = contentBox == null ? 0f : contentBox.getWidth();
		float ch = contentBox == null ? 0f : contentBox.getHeight();
		float llx, lly, urx, ury;
		llx = cw * containerXFactor + width * elementXFactor + offsetX * offsetXFactor;
		lly = ch * containerYFactor + height * elementYFactor + offsetY * offsetYFactor;
		urx = llx + width;
		ury = lly + height;

		llx += contentBox.getLeft();
		lly += contentBox.getBottom();
		urx += contentBox.getLeft();
		ury += contentBox.getBottom();

		ContentBox element = new ContentBox(llx, lly, urx, ury);
		element.setLeft(llx);
		element.setBottom(lly);
		element.setRight(urx);
		element.setTop(ury);
		return element;
	}

	public ContentBox anchorElement(ContentBox contentBox, float width, float height) {
		return anchorElement(contentBox, width, height, 0f, 0f);
	}

	public ContentBox anchorElement(ContentBox contentBox, ContentBox element, float offsetX, float offsetY) {
		float width = element == null ? 0f : element.getWidth();
		float height = element == null ? 0f : element.getHeight();
		return anchorElement(contentBox, width, height, offsetX, offsetY);
	}

	public ContentBox anchorElement(ContentBox page, ContentBox element) {
		return anchorElement(page, element, 0f, 0f);
	}
}
