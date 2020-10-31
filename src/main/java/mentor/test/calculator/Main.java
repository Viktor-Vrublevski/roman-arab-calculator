package mentor.test.calculator;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       try {
           while (true) {
               Execute execute = new Execute(reader);
           }
       }catch (Exception ignored){

       }

    }
}
