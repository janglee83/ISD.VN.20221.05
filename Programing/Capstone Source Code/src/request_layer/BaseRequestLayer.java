package request_layer;

import java.util.HashMap;

public class BaseRequestLayer {

    private String validationErrors;

    private HashMap<Integer, String> defaultErrorMsg;

    protected String fieldToValidate;

    // types of predefined validators:
	protected final int REQUIRED = 1;
	protected final int UNIQUE = 2;
	protected final int INT = 3;
	protected final int EMAIL = 4;
	protected final int NUMBER = 5;
	protected final int POSITIVE_NUMBER = 6;
    protected final int TEXT = 7;
    protected final int PHONE_NUMBER = 8;

    public BaseRequestLayer() {
        defaultErrorMsg = new HashMap<Integer, String>()
        {{
            put(REQUIRED, "This field must be filled in");
            put(UNIQUE, "This value is already in use");
            put(INT, "Positive integer value is required");
            put(EMAIL, "Invalid e-mail address format");
            put(NUMBER, "Number is required");
            put(POSITIVE_NUMBER, "Positive number is required");
            put(TEXT, "Require only text");
            put(PHONE_NUMBER, "Phone number number is required");
        }};
    }

    public String getValidationErrors() {
        return validationErrors;
    }

    public void validateField(Integer type, String message) throws Exception {
        switch (type) {
            case REQUIRED:
                if (fieldToValidate == "")
                    throw new Exception(handleReturnMessage(defaultErrorMsg.get(type), message));
                break;
            case TEXT:
                if (fieldToValidate.matches("^[a-zA-Z0-9 ]*$") == false)
                    throw new Exception(handleReturnMessage(defaultErrorMsg.get(type), message));
                break;
            case PHONE_NUMBER:
                if (fieldToValidate.length() != 10)
                    if (Character.compare(fieldToValidate.charAt(0), '0') != 0)
                        throw new Exception(handleReturnMessage(defaultErrorMsg.get(type), message));
                break;
            default:
                break;
        }
	}

    private String handleReturnMessage(String originMsg, String newMessage) {
        if (newMessage.length() == 0)
            return originMsg;
        else return newMessage;
    }
}
