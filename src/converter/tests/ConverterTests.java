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

    @Test
    public void KibenianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("1");
        assertEquals(converter.toKibenian(), "I");
    }

    @Test
    public void ArabicToKibenianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LLXXVI");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XL");
        converter.toArabic();
    }

    @Test(expected = MalformedNumberException.class) //over 60 in one segment
    public void malformedNumberTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX");
        converter.toArabic();
    }

    @Test //59 in one segment
    public void malformedNumberTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIIII");
        assertEquals(converter.toKibenian(), 59);
    }

    @Test(expected = MalformedNumberException.class) //59 in one segment
    public void malformedNumberTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XXXXX");
    }

    @Test(expected = MalformedNumberException.class) //2 Vs in a row
    public void malformedNumberTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVV");
    }

    @Test(expected = MalformedNumberException.class) //5 Is in a row
    public void malformedNumberTest8() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIIII");
    }

    @Test //4 Is in a row
    public void malformedNumberTest9() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII");
        assertEquals(converter.toKibenian(), 19);
    }

    @Test(expected = MalformedNumberException.class) //Underscore
    public void malformedNumberTest10() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LX_XVIIII");
    }

    @Test //Underscore
    public void malformedNumberTest11() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LXXXII_XVIIII");
    }

    @Test //Underscore
    public void malformedNumberTest12() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("LVIII_XVIIII");
        assertEquals(converter.toKibenian(), 3499);
    }

    @Test //Underscore
    public void malformedNumberTest13() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII__XVIIII");
        assertEquals(converter.toKibenian(), 1159);
    }

    @Test //Underscore
    public void malformedNumberTest14() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("_XVIIII");
        assertEquals(converter.toKibenian(), 1159);
    }

    @Test //Underscore
    public void malformedNumberTest15() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("XVIIII_");
        assertEquals(converter.toKibenian(), 1159);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueBelowBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected  = ValueOutOfBoundsException.class)
    public void valueBelowBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("-30");
        converter.toKibenian();
    }

    @Test(expected  = ValueOutOfBoundsException.class)
    public void valueAboveBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("428459");
        converter.toKibenian();
    }

    @Test(expected  = ValueOutOfBoundsException.class)
    public void valueAboveBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        KibenianArabicConverter converter = new KibenianArabicConverter("428959");
        converter.toKibenian();
    }
    // TODO Add more test cases
}
