package request_layer;

public class Card_RL extends BaseRequestLayer {

	public void validateString(String name) throws Exception {
		super.fieldToValidate = name;
        super.validateField(super.REQUIRED, "");
		super.validateField(super.TEXT, "");
	}

	public void validateStringNumber(String stringNumber) throws Exception {
		super.fieldToValidate = stringNumber;
        super.validateField(super.REQUIRED, "");

		try {
			double d = Double.parseDouble(stringNumber);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		}
	}

}
