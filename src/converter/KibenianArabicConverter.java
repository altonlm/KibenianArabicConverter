package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Kibenian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/31/2023
 */
public class KibenianArabicConverter {

    // A string that holds the number (Kibenian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the KibenianArabic class that takes a string. The string should contain a valid
     * Kibenian or Arabic numeral. See the assignment instructions for what constitutes a correct input
     * and what exceptions should be raised.
     *
     * @param number A string that represents either a Kibenian or Arabic number.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic integer that cannot be represented
     * in the Kibenian number system.
     * @throws MalformedNumberException Thrown if the value is an Kibenian number that does not conform
     * to the rules of the Kibenian number system or any other error in Arabic number input.
     */
    public KibenianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        return 1;
    }

    /**
     * Converts the number to an Kibenian numeral or returns the current value if it is already in the Kibenian form.
     *
     * @return A Kibenian value
     */
    public String toKibenian() throws MalformedNumberException {
        // TODO Fill in the method's body
        String numFiltered = number.replaceAll("[LXVI_]","");
        if (numFiltered.length() > 0)
            throw new MalformedNumberException(number);

        if (number.contains("__")||number.contains("LL")||number.contains("XXXXX")||number.contains("VV")
                ||number.contains("IIIII")||number.contains("XL")||number.contains("VL")||number.contains("IL")
                ||number.contains("VX")||number.contains("IX")||number.contains("IV")
                ||number.substring(0,1).equals("_")||number.substring(number.length()-1,number.length()).equals("_"))
            throw new MalformedNumberException(number);

        String[] numArray = number.split("_");




        return "I";
    }

}
