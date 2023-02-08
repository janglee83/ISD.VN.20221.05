package request_layer;

public class Card_RL {

	public void validateString(String name) throws Exception {
		// Check name is not null
		if (name == "")
			throw new Exception();
		// Check if contain only leter and space
		if (name.matches("^[a-zA-Z0-9 ]*$") == false)
			throw new Exception();
	}

	public void validateStringNumber(String stringNumber) throws Exception {
		// Check name is not null
		if (stringNumber == "")
			throw new Exception();

		try {
			double d = Double.parseDouble(stringNumber);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException();
		}
	}

}
