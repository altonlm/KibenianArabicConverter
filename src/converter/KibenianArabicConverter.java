package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;


/**
 * This class implements a converter that takes a string that represents a number in either the
 * Kibenian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/31/2023
 */
public class KibenianArabicConverter {

    // A string that holds the number (Kibenian or Arabic) you would like to convert
    private final String number;
    private final boolean isArabic;
    private final boolean isKibenian;
    private final int arabicValue;
    private final String kibenianValue;


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
        this.number = number;

        this.isArabic = isArabic();
        this.isKibenian = isKibenian();

        if ((!isArabic) && (!isKibenian))
            throw new MalformedNumberException(number);

        int arabicValueTemp = 0;
        String kibenianValueTemp = "";

        if (isArabic){
            int value = Integer.parseInt(number);
            if (value < 1 || value > 428458)
                throw new ValueOutOfBoundsException(number);

            arabicValueTemp = value;
            kibenianValueTemp = convertArabicToKibenian(number);
        }

        if (isKibenian){
            kibenianValueTemp = number;
            arabicValueTemp = convertKibenianToArabic(number);
        }

        this.arabicValue = arabicValueTemp;
        this.kibenianValue = kibenianValueTemp;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        return this.arabicValue;
    }

    /**
     * Converts the number to an Kibenian numeral or returns the current value if it is already in the Kibenian form.
     *
     * @return A Kibenian value
     */
    public String toKibenian() throws MalformedNumberException {
        return this.kibenianValue;
    }

    private boolean isKibenian(){
        String numFiltered = number.replaceAll("[LXVI_]","");
        if (numFiltered.length() > 0)
            return false;

        if (number.contains("LL")||number.contains("XXXXX")||number.contains("VV")
                ||number.contains("IIIII")||number.contains("XL")||number.contains("VL")||number.contains("IL")
                ||number.contains("VX")||number.contains("IX")||number.contains("IV")
                ||number.substring(0,1).equals("_")||number.substring(number.length()-1,number.length()).equals("_"))
            return false;

        return true;
    }

    private boolean isArabic(){
        //Check for disallowed characters
        String numFiltered = number.replaceAll("[1234567890]","");
        if (numFiltered.length() > 0)
            return false;

        //Check for leading zeros
        if (number.substring(0, 1).equals("0"))
            return false;

        return true;
    }

    private String convertArabicToKibenian(String arabic){
        ArrayList<Integer> blockValues = new ArrayList<Integer>();
        int value = Integer.parseInt(arabic);
        while (value!=0){
            Integer blockValue = value%60;
            blockValues.add(blockValue);
            value /= 60;
        }
        String kibenianNum = "";
        for (int j = 0; j < blockValues.size()-1; j++){
            kibenianNum += convertArabicNumberToKibenianBlock(blockValues.get(j))+"_";
        }
        kibenianNum += convertArabicNumberToKibenianBlock(blockValues.get(blockValues.size()-1));

        return kibenianNum;
    }

    private String convertArabicNumberToKibenianBlock(int arabicNum){
        String kibenianNum = "";
        while (arabicNum >= 50){
            arabicNum -= 50;
            kibenianNum += "L";
        }

        while (arabicNum >= 10){
            arabicNum -= 10;
            kibenianNum += "X";
        }

        while (arabicNum >= 5){
            arabicNum -= 5;
            kibenianNum += "V";
        }

        while (arabicNum >= 1){
            arabicNum -= 1;
            kibenianNum += "I";
        }
        return kibenianNum;
    }

    private int convertKibenianToArabic(String kibenian){
        String[] blocks = kibenian.split("_");
        int count = 0;

        for (int j = 0; j < blocks.length; j++){
            count += convertKibenianBlockToInteger(blocks[j]) * 60^j;
        }
        return count;
    }

    private int convertKibenianBlockToInteger(String kibenianBlock){
        int numLs = (kibenianBlock.split("L").length) - 1;
        int numXs = (kibenianBlock.split("X").length) - 1;
        int numVs = (kibenianBlock.split("V").length) - 1;
        int numIs = (kibenianBlock.split("I").length) - 1;
        return  numLs*50 + numXs*10 + numVs*5 + numIs;
    }

}
