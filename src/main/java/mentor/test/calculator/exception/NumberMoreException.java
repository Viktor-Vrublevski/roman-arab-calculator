package mentor.test.calculator.exception;

public class NumberMoreException extends Exception{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public NumberMoreException(){
        System.out.println(ANSI_GREEN+"The value must be no more than 10"+ANSI_RESET);
    }
}
