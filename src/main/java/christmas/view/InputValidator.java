package christmas.view;

import static christmas.utils.Constants.MAX_NUMBER_IN_RANGE;
import static christmas.utils.Constants.MIN_NUMBER_IN_RANGE;
import static christmas.utils.ErrorMessages.INPUT_NUMBER_FORMAT;

public class InputValidator {

    public static int parseNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT);
        }
    }

    public static int checkNumberInRange(int date) {
        if (date < MIN_NUMBER_IN_RANGE || date > MAX_NUMBER_IN_RANGE) throw new IllegalArgumentException(INPUT_NUMBER_FORMAT);
        return date;
    }
}
