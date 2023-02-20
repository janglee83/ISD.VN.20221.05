package request_layer;

public class ReturnBike_RL extends BaseRequestLayer {

    public void validateName(String name) throws Exception {
        // // Check name is not null
        // if (name == null)
        //     throw new Exception();
        // // Check if contain only leter and space
        // if (name.matches("^[a-zA-Z ]*$") == false)
        //     throw new Exception();
        super.fieldToValidate = name;
        super.validateField(super.REQUIRED, "");
    }

    public boolean validateAddress(String address) {
        // Check address is not null
        if (address == null)
            return false;
        // Check if contain leter space only
        if (address.trim().length() == 0)
            return false;
        // Check if contain only leter and space
        if (address.matches("^[a-zA-Z ]*$") == false)
            return false;
        return true;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        // check the phoneNumber has 10 digits
        if (phoneNumber.length() != 10)
            return false;
        if (Character.compare(phoneNumber.charAt(0), '0') != 0)
            return false;
        // check the phoneNumber contains only number
        try {
            Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
