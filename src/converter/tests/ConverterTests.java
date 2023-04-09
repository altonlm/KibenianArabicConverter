package converter.tests;

import converter.KibenianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the KibenianArabicConverter class.
 */
public class ConverterTests {

    //START KIBENIAN TO KIBENIAN
    @Test
    public void KibenianToKibenianTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toKibenian(), "I");
    }

    @Test //59 in one segment
    public void KibenianToKibenianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIIII");
        assertEquals(converter.toKibenian(), "LVIIII");
    }

    @Test //4 Is in a row
    public void KibenianToKibenianTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII");
        assertEquals(converter.toKibenian(), "XVIIII");
    }

    @Test
    public void KibenianToKibenianTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVII_XXXVII");
        assertEquals(converter.toKibenian(), "LVII_XXXVII");
    }

    @Test
    public void KibenianToKibenianTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIII_XXXV_VIIII");
        assertEquals(converter.toKibenian(), "XVIII_XXXV_VIIII");
    }

    //END KIBENIAN TO KIBENIAN

    //START ARABIC TO KIBENIAN
    @Test
    public void ArabicToKibenianTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toKibenian(), "I");
    }

    @Test //59 in one segment
    public void ArabicToKibenianTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("59");
        assertEquals(converter.toKibenian(), "LVIIII");
    }

    @Test //4 Is in a row
    public void ArabicToKibenianTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("19");
        assertEquals(converter.toKibenian(), "XVIIII");
    }

    @Test
    public void ArabicToKibenianTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3457");
        assertEquals(converter.toKibenian(), "LVII_XXXVII");
    }

    @Test
    public void ArabicToKibenianTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("66909");
        assertEquals(converter.toKibenian(), "XVIII_XXXV_VIIII");
    }

    //END ARABIC TO KIBENIAN TESTS

    //START KIBENIAN TO ARABIC TESTS
    @Test //4 Is in a row
    public void KibenianToArabicTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII");
        assertEquals(converter.toArabic(), 19);
    }

    @Test //59 in one segment
    public void KibenianToArabicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIIII");
        assertEquals(converter.toArabic(), 59);
    }

    @Test //Underscore
    public void KibenianToArabicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIII_XVIIII");
        assertEquals(converter.toArabic(), 3499);
    }

    @Test //Underscore
    public void KibenianToArabicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII__XVIIII");
        assertEquals(converter.toArabic(), 68419);
    }
    //END KIBENIAN TO ARABIC TESTS

    //START ARABIC TO ARABIC TESTS
    @Test //4 Is in a row
    public void ArabicToArabicTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("19");
        assertEquals(converter.toArabic(), 19);
    }

    @Test //59 in one segment
    public void ArabicToArabicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("59");
        assertEquals(converter.toArabic(), 59);
    }

    @Test //Underscore
    public void ArabicToArabicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("3499");
        assertEquals(converter.toArabic(), 3499);
    }

    @Test //Underscore
    public void ArabicToArabicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("68419");
        assertEquals(converter.toArabic(), 68419);
    }
    //END ARABIC TO ARABIC TESTS


    //START KIBENIAN MALFORMED NUMBER TESTS
    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LLXXVI");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XL");
    }

    @Test(expected = MalformedNumberException.class) //over 60 in one segment
    public void KibenianMalformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX");
    }

    @Test(expected = MalformedNumberException.class) //59 in one segment
    public void KibenianMalformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXXX");
    }

    @Test(expected = MalformedNumberException.class) //2 Vs in a row
    public void KibenianMalformedNumberTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVV");
    }

    @Test(expected = MalformedNumberException.class) //5 Is in a row
    public void KibenianMalformedNumberTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIIII");
    }

    @Test(expected = MalformedNumberException.class) //Underscore
    public void KibenianMalformedNumberTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX_XVIIII");
    }

    @Test(expected = MalformedNumberException.class) //Underscore
    public void KibenianMalformedNumberTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LXXXII_XVIIII");
    }

    @Test (expected = MalformedNumberException.class)//Underscore
    public void KibenianMalformedNumberTest19() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_XVIIII");
    }

    @Test (expected = MalformedNumberException.class)//Underscore
    public void KibenianMalformedNumberTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII_");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVII_XXVXII");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVI_XV ");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(" LVI_XV");
    }

    @Test(expected = MalformedNumberException.class)
    public void KibenianMalformedNumberTest15() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LV_LV_LVI_XV");
    }

    //END KIBENIAN MALFORMED NUMBER TESTS


    //START ARABIC MALFORMED NUMBER TESTS
    @Test(expected = MalformedNumberException.class)
    public void ArabicMalformedNumberTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("12345.0");
    }

    @Test(expected = MalformedNumberException.class)
    public void ArabicMalformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("0012345");
    }

    @Test(expected = MalformedNumberException.class)
    public void ArabicMalformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter(" 12345");
    }

    @Test(expected = MalformedNumberException.class)
    public void ArabicMalformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("12345 ");
    }

    //END ARABIC MALFORMED NUMBER TESTS


    //START OF ARABIC BOUNDS TESTS

    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicBoundsTest1() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("216000");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("227359");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicBoundsTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void ArabicBoundsTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-30");
    }

    @Test()
    public void ArabicBoundsTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("215999");
        assertEquals(converter.toArabic(), 215999);
    }

    //END OF ARABIC BOUNDS TESTS
}
