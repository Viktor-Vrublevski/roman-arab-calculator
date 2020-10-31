package mentor.test.calculator.services.rome;

import mentor.test.calculator.exception.NumberLessException;
import mentor.test.calculator.exception.NumberMoreException;
import mentor.test.calculator.exception.WrongFormatException;
import mentor.test.calculator.services.AbstractStringService;

import java.util.*;

/*
Класс для работы с римскими цифрами;
public class RomeService extends AbstractStringService {

    private static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

    static {
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
    }

    public String[] romeArray = new String[3];

    /*
       метод проверяет, соответствуют ли элементы массива римским цифрам и
       заполняет массив romeArray , который необходим в кач-ве параметра для метода
       getResultArab(String[] array) в классе Execute;
    */
    public boolean checkDigits(String[] array) throws Exception {
        boolean f1 = false;
        boolean f2 = false;
        String str1 = array[0];
        String str2 = array[2];
        int a = 0;
        int b = 0;
        if (isRomeDigit(str1)) {
            if (isRules(str1))
                a = getArabFromRome(str1);
            f1 = true;
        } else throw new WrongFormatException();
        if (isRomeDigit(str2)) {
            if (isRules(str2))
                b = getArabFromRome(str2);
            f2 = true;
        } else throw new WrongFormatException();

        if (a < 1 | b < 1) throw new NumberLessException();
        if (a > 10 | b > 10) throw new NumberMoreException();

        romeArray[0] = String.valueOf(a);
        romeArray[1] = array[1];
        romeArray[2] = String.valueOf(b);

        return f1 & f2;
    }

    /*
    Метод возращает чилсо из строки, записанной римскими цифрами.
    Строка перед записыванием в кач-ве параметра, уже прошла проверку и
      записана  по всем принципам римсокого исчесления;
     */
    public int getArabFromRome(String str) {
        int result = 0;
        String minus = "";
        if (str.startsWith("-")) {
            str = str.substring(1);
            minus = "-";
        }

        while (str.length() > 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (str.startsWith(entry.getKey())) {
                    result += entry.getValue();
                    str = str.substring(entry.getKey().length());
                }
            }
        }
        if (minus.equals("-")) result *= -1;
        return result;
    }


    /*
    Метод возвращает  строку  римского числа;
     */
    public String getRomeFromArab(int number) {
        StringBuilder str = new StringBuilder();
        while (number > 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (number >= entry.getValue()) {
                    number = number - entry.getValue();
                    str.append(entry.getKey());
                    break;
                }
            }
        }

        return str.toString();
    }

    /*
    Метод проверяет находятся ли в строке посторонние символы. Символы отличные от I, X, V
    Если находятся отличные символы, выкидывается исключение.
     */
    public boolean isRomeDigit(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 & chars[i] == '-') continue;
            if (chars[i] != 'I')
                if (chars[i] != 'V')
                    if (chars[i] != 'X')
                        if (chars[i] != 'L') return false;
        }
        return true;
    }

    /*
    Метод проверяет соответствует ли строка правилам римской системы исчисления;
     */
    public boolean isRules(String str) {
        char[] chars = str.toCharArray();
        int count_V = 0;
        int count_I = 0;
        int count_L = 0;
        int count_less = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 & chars[i] == '-') continue;
            if (chars[i] == 'V') count_V++;
            if (chars[i] == 'I') count_I++;
            if (chars[i] == 'L') count_L++;
            if (i > 0) {
                if (chars[i - 1] != '-' && map.get(String.valueOf(chars[i])) > map.get(String.valueOf(chars[i - 1]))) {
                    count_less++;
                    continue;
                }
                if (chars[i - 1] != '-' && map.get(String.valueOf(chars[i])) < map.get(String.valueOf(chars[i - 1]))
                        && count_less >= 1) {
                    return false;
                }
            }
        }
        if (count_I > 3) return false;
        if (count_L > 1) return false;
        return count_V <= 1;
    }

}
