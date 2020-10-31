package mentor.test.calculator.exception;

public class NumberLessException extends Exception{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public NumberLessException(){
        System.out.println(ANSI_CYAN + "Значение должно быть не меньше 1"+ANSI_RESET);
    }
}
