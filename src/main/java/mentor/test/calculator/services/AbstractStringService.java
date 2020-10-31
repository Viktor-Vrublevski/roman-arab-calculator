package mentor.test.calculator.services;

public abstract class AbstractStringService {

    /*
        ����� �������� �� ������� �������� ������ �����;
        ��������� ������ ������ ���� �������� ������ 3;
        ���� ���������(+, -, /, *) ������ �������� � ��������� ������;
    */
    public String[] getArrayNumbersAndOperator(char[] chars) {
        String[] strings = new String[3];
        int count = 0;
        for (int i = 0; i < strings.length - 1; ) {
            count++;
            if (count == chars.length - 1) break;
            for (int j = 0; j < chars.length; j++) {
//         ���� ������, �� ����������(�� ����������� � ������)
                if (chars[j] == ' ') continue;
//          ���� ������� ��������� ����� ���� �����, ��������� � ������
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

     ����� ��������� �������� �� array[0] � array[2] ��������������� ����������
     (�.� �������� �� ��������� ���� �������� �������);
   */
    public abstract boolean checkDigits(String[] array) throws Exception;

    /*
        ����� ���������, �������� �� ������ ������ ���������: '+' , '-' '*', '/'  ;
     */
    protected boolean isContain(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }
}
