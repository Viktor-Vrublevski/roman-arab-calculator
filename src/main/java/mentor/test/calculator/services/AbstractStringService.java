package mentor.test.calculator.services;

public abstract class AbstractStringService {

    /*
        Метод получает из массива символов массив строк;
        Возратный массив должен быть размером равным 3;
        Знак оператора(+, -, /, *) должен хранится в отдельной ячейке;
    */
    public String[] getArrayNumbersAndOperator(char[] chars) {
        String[] strings = new String[3];
        int count = 0;
        for (int i = 0; i < strings.length - 1; ) {
            count++;
            if (count == chars.length - 1) break;
            for (int j = 0; j < chars.length; j++) {
//         Если пробел, то продолжаем(не присваеваем в массив)
                if (chars[j] == ' ') continue;
//          Если вначале выражения стоит знак минус, вписываем в массив
                if (chars[j] == '-' && j == 0) {
                    strings[i] = "-";
                    j++;
                }
                if (!isContain(chars[j])) {
                    if (strings[i] != null) {
                        strings[i] = strings[i] + chars[j];
                    } else strings[i] = String.valueOf(chars[j]);
                } else {
                    i++;
                    strings[i] = String.valueOf(chars[j]);
                    i++;
                }

            }
        }
        return strings;
    }


    /*

     Метод проверяет являются ли array[0] и array[2] соответсвующими значениями
     (т.е являются ли арабскими либо римскими цифпами);
   */
    public abstract boolean checkDigits(String[] array) throws Exception;

    /*
        Метод проверяет, является ли символ знаком оператора: '+' , '-' '*', '/'  ;
     */
    protected boolean isContain(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }
}
