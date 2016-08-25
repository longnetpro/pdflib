package info.longnetpro.pdflib.document;

public class ContentBox {
	private float left = 0f;
	private float bottom = 0f;
	private float right = 0f;
	private float top = 0f;

	public ContentBox() {
		super();
	}

	public ContentBox(float width, float height) {
		this(0f, 0f, width, height);
	}

	public ContentBox(float llx, float lly, float urx, float ury) {
		this.left = llx;
		this.bottom = lly;
		this.right = urx;
		this.top = ury;
	}

	public float getWidth() {
		float width = right - left;
		return width > 0 ? width : -width;
	}

	public float getHeight() {
		float height = top - bottom;
		return height > 0 ? height : -height;
	}

	public void setWidthFromLeft(float width) {
		setRight(left + width);
	}

	public void setWidthFromRight(float width) {
		setLeft(right - width);
	}

	public void setHeightFromBottom(float height) {
		setTop(bottom + height);
	}

	public void setHeightFromTop(float height) {
		setBottom(top - height);
	}

	public void setLeft(float left) {
		this.left = left;
	}

	public float getLeft() {
		return left;
	}

	public void setBottom(float bottom) {
		this.bottom = bottom;
	}

	public float getBottom() {
		return bottom;
	}

	public void setRight(float right) {
		this.right = right;
	}

	public float getRight() {
		return right;
	}

	public void setTop(float top) {
		this.top = top;
	}

	public float getTop() {
		return top;
	}
}
