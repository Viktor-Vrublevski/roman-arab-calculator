package mentor.test.calculator;

import mentor.test.calculator.exception.WrongFormatException;
import mentor.test.calculator.services.arab.ArabService;
import mentor.test.calculator.services.rome.RomeService;
import org.junit.Assert;
import org.junit.Test;


public class MainTest {


    @Test
    public void testArrayNumbersAndOperator(){
        String str = "456+IV";
        ArabService handler = new ArabService();
        String[] array = handler.getArrayNumbersAndOperator(str.toCharArray());
        for (String s : array){
            System.out.println(s);
        }
        Assert.assertEquals(3,array.length);
    }

    @Test
    public void testCheckArabDigits() throws Exception {
        String str = "2  + 4";
        ArabService handler = new ArabService();
        String[] array = handler.getArrayNumbersAndOperator(str.toCharArray());
        Assert.assertTrue(handler.checkDigits(array));
    }

    @Test
    public void testRomeDigit() throws WrongFormatException {
        String str = "";
        RomeService rome = new RomeService();
        boolean is = rome.isRomeDigit(str);
        Assert.assertTrue(is);
    }

    @Test
    public void testGetArabFromRome(){
        String str = "LXXII";
        RomeService rome = new RomeService();
        int result = rome.getArabFromRome(str);

        Assert.assertEquals(72,result);
    }

    @Test
    public void testGetRomeFromArab(){
        int number = 72;
        RomeService rome = new RomeService();
        String str = rome.getRomeFromArab(number);
        Assert.assertEquals("LXXII",str);
    }

    @Test
    public void testIsRules(){
        String str = "XIV";
        RomeService rome = new RomeService();
        Assert.assertTrue(rome.isRules(str));
    }

    @Test
    public void testCheckRmeDigits() throws Exception {
        String str = "IV  + VIII";
        RomeService handler = new RomeService();
        String[] array = handler.getArrayNumbersAndOperator(str.toCharArray());
        Assert.assertTrue(handler.checkDigits(array));
    }
}
