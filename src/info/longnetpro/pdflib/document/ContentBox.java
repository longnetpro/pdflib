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

	public ContentBox duplicate() {
		ContentBox contentBox = new ContentBox(left, bottom, right, top);
		return contentBox;
	}

	public float[] scaleByWidth(float newWidth) {
		float[] dim = new float[2];
		dim[0] = newWidth;
		dim[1] = getWidth() == 0 ? getHeight() : getHeight() * newWidth / getWidth();
		return dim;
	}

	public float[] scaleByHeight(float newHeight) {
		float[] dim = new float[2];
		dim[0] = getHeight() == 0 ? getWidth() : getWidth() * newHeight / getHeight();
		dim[1] = newHeight;
		return dim;
	}

	public float[] scaleByPercentage(float percentage) {
		float[] dim = new float[2];
		dim[0] = getWidth() * percentage;
		dim[1] = getHeight() * percentage;
		return dim;
	}

	public float[] scaleByPercentage(float widthPercentage, float heightPercentage) {
		float[] dim = new float[2];
		dim[0] = getWidth() * widthPercentage;
		dim[1] = getHeight() * heightPercentage;
		return dim;
	}

	public ContentBox reposition(float width, float height, Anchor anchor) {
		ContentBox contentBox = anchor.anchorElement(this, width, height);
		return contentBox;
	}
}
