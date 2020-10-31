package mentor.test.calculator;

import mentor.test.calculator.exception.NumberLessException;
import mentor.test.calculator.exception.NumberMoreException;
import mentor.test.calculator.exception.WrongFormatException;
import mentor.test.calculator.services.arab.ArabService;
import mentor.test.calculator.services.rome.RomeService;

import java.io.BufferedReader;



public class Execute {

    private BufferedReader reader;
    private String str;

    public Execute(BufferedReader reader) throws Exception {
        System.out.println("Input");
        this.reader = reader;

           str = reader.readLine();
           ArabService arab = new ArabService();
           RomeService rome = new RomeService();

           if (str.matches("-\\d*\\s*[-+*/]\\s*\\d*|\\d*\\s*[-+*/]\\s*\\d*")) {
               if (arab.checkDigits(arab.getArrayNumbersAndOperator(str.toCharArray()))) {
                   System.out.println("Output" + "\n" +
                           getResultArab(arab.getArrayNumbersAndOperator(str.toCharArray())));
               }
           } else if (rome.checkDigits(rome.getArrayNumbersAndOperator(str.toCharArray()))) {
               int number = getResultArab(rome.romeArray);
               System.out.println("Output" + "\n" + rome.getRomeFromArab(number));
           }


    }


    public int getResultArab(String[] array) {
        int result = 0;
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);

        if ("+".equals(array[1])) {
            result = MyMath.add(a, b);
        } else if ("-".equals(array[1])) {
            result = MyMath.sub(a, b);
        } else if ("*".equals(array[1])) {
            result = MyMath.multi(a, b);
        } else if ("/".equals(array[1])) {
            result = MyMath.div(a, b);
        }
        return result;
    }


}
