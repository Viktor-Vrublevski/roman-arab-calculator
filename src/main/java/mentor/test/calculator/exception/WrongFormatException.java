package mentor.test.calculator.exception;

public class WrongFormatException extends Exception{

    public WrongFormatException(){
        System.err.println("Не правильный формат ввода цифр");
     }
}
