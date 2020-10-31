package mentor.test.calculator.exception;

public class WrongFormatException extends Exception{

    public WrongFormatException(){
        System.err.println("Incorrect number input format");
     }
}
