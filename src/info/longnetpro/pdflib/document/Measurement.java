package info.longnetpro.pdflib.document;

public class Measurement {
	public static final float DEFAULT_USER_UNIT_SIZE = 1f / 72f; // by inch
	public static final float MILLIMETERS_PER_INCH = 25.4f;
	public static final float DEFAULT_USER_UNIT_MULTIPLIER = 1.0f;

	public static float getActualUserUnitSize(float multiplier) {
		return multiplier * DEFAULT_USER_UNIT_SIZE; // by inch
	}

	public static float getActualUserUnitSize() {
		return DEFAULT_USER_UNIT_MULTIPLIER * DEFAULT_USER_UNIT_SIZE; // by inch
	}

	public static float inchesToMillimeters(float inches) {
		return inches * MILLIMETERS_PER_INCH;
	}

	public static float millimetersToInches(float mm) {
		return mm / MILLIMETERS_PER_INCH;
	}

	public static float inchesToUserUnits(float inches, float multiplier) {
		return inches / getActualUserUnitSize(multiplier);
	}

	public static float inchesToUserUnits(float inches) {
		return inches / getActualUserUnitSize(DEFAULT_USER_UNIT_MULTIPLIER);
	}

	public static float millimetersToUserUnits(float mm, float multiplier) {
		return inchesToUserUnits(millimetersToInches(mm), multiplier);
	}

	public static float millimetersToUserUnits(float mm) {
		return inchesToUserUnits(millimetersToInches(mm), DEFAULT_USER_UNIT_MULTIPLIER);
	}

	public static float userUnitsToInches(float units, float multiplier) {
		return units * getActualUserUnitSize(multiplier);
	}

	public static float userUnitsToInches(float units) {
		return units * getActualUserUnitSize(DEFAULT_USER_UNIT_MULTIPLIER);
	}

	public static float userUnitsToMillimeters(float units, float multiplier) {
		return inchesToMillimeters(userUnitsToInches(units, multiplier));
	}

	public static float userUnitsToMillimeters(float units) {
		return inchesToMillimeters(userUnitsToInches(units, DEFAULT_USER_UNIT_MULTIPLIER));
	}

	private float userUnitMultiplier = DEFAULT_USER_UNIT_MULTIPLIER;
	private float userUnits = 0f;
	private float inches = 0f;
	private float millimeters = 0f;

	public Measurement() {
		super();
	}

	public Measurement(float multiplier) {
		super();
		this.userUnitMultiplier = multiplier;
	}

	public Measurement setUserUnits(float userUnits) {
		this.userUnits = userUnits;
		this.inches = userUnitsToInches(userUnits, userUnitMultiplier);
		this.millimeters = userUnitsToMillimeters(userUnits, userUnitMultiplier);
		return this;
	}

	public float getUserUnits() {
		return userUnits;
	}

	public Measurement setInches(float inches) {
		this.inches = inches;
		this.millimeters = inchesToMillimeters(inches);
		this.userUnits = inchesToUserUnits(inches, userUnitMultiplier);
		return this;
	}

	public float getInches() {
		return inches;
	}

	public Measurement setMillimeters(float millimeters) {
		this.millimeters = millimeters;
		this.inches = millimetersToInches(millimeters);
		this.userUnits = millimetersToUserUnits(millimeters, userUnitMultiplier);
		return this;
	}

	public float getMillimeters() {
		return millimeters;
	}

	public Measurement setUserUnitMultiplier(float userUnitMultiplier) {
		this.userUnitMultiplier = userUnitMultiplier;
		this.inches = userUnitsToInches(userUnits, userUnitMultiplier);
		this.millimeters = inchesToMillimeters(inches);
		return this;
	}

	public Measurement defaultUserUnitMultiplier() {
		return setUserUnitMultiplier(DEFAULT_USER_UNIT_MULTIPLIER);
	}

	public float getUserUnitMultiplier() {
		return userUnitMultiplier;
	}

	public static void main(String[] args) {
		Measurement mes = new Measurement().setUserUnitMultiplier(2f).setInches(1f);
		System.out.println(mes.getMillimeters());
	}
}
