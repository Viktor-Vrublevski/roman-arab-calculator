package mentor.test.calculator.services.arab;

import mentor.test.calculator.MyMath;
import mentor.test.calculator.exception.NumberLessException;
import mentor.test.calculator.exception.NumberMoreException;
import mentor.test.calculator.services.AbstractStringService;

/*
����� ��� ������ ���  ������� � ��������� �������. ������: �������� �� ������ �������� � ��������.
��������� ������������ �� �������� �������� ����������;
 */
public class ArabService extends AbstractStringService {


    /*
    ����� ���������, ������������� �� �������� ������� �������� ������;
     */
    public boolean checkDigits(String[] array) throws Exception {
        if (array.length != 3) return false;
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[2]);
        } catch (NumberFormatException e) {
            System.err.println("�������� ������� �� ���������");
        }
        if (a < 1 | b < 1) throw new NumberLessException();
        if (a > 10 | b > 10) throw new NumberMoreException();
            return true;
    }


}
