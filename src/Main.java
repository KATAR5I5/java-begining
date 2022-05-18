import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {



    public static void main(String[] arg) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String strFirst;
        do {
            System.out.println("Введите выражение типа (а + в)...");
            strFirst = bufferedReader.readLine();
        }
        while (strFirst.isEmpty());{
            // проверка на пустоту
        }
        String str = strFirst.trim(); // del spase
        str = str.toUpperCase();
        //Output
        System.out.println(calc(str));
    }
    public static String calc(String input) throws Exception {
        String[] strings = input.split(" ");  // Массив операндов
        try {
            if (strings.length >= 4)
                throw new Exception();
        }catch (Exception e) {
            return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        }
        try {
            if (strings.length < 3)
                throw new Exception();
        }catch (Exception e4) {
            return "throws Exception //т.к. строка не является математической операцией";
        }
        int firstNumInt, secondNumInt;
        String firstNumStr = strings[0];
        String secondNumStr = strings[2];
        String sign = strings[1];
        try {
            firstNumInt = Integer.parseInt(firstNumStr);  // может быть не число
            secondNumInt = Integer.parseInt(secondNumStr); // может быть не число
            String arabicNum = calcArabic(firstNumInt, secondNumInt, sign);
            return (arabicNum);
        } catch (Exception e) {
            try {
                firstNumInt = getRomeNumber(firstNumStr);
                secondNumInt = getRomeNumber(secondNumStr);
                try {
                    if (!(1 <=firstNumInt && firstNumInt <= 10 & secondNumInt>= 1 & secondNumInt <= 10))
                        throw new Exception();
                }catch (Exception e1) {
                    return "throws Exception //Операнд находится за пределами от 1 до 10 включительно.";
                }

                int arabicNumRome = Integer.parseInt(calcArabic(firstNumInt, secondNumInt, sign));
                if (arabicNumRome <= 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e1) {
                        return "throws Exception //т.к. в римской системе нет отрицательных чисел.";
                    }
                }
                String romeName = romeName(arabicNumRome);
                return (romeName);
            } catch (Exception e2) {
                return "throws Exception //т.к. используются одновременно разные системы счисления";
            }
        }
    }
    //    Метод арифметических действий с арабскими числами
    static String calcArabic(int a, int b, String c) throws Exception {
        String sign = c;
        String result = null;
        if (a >= 1 & a <= 10 && b >= 1 & b <= 10) {
            switch (sign) {
                case "+":
                    int sum = a + b;
                    result = Integer.toString(sum);
                    break;
                case "-":
                    int subtraction = a - b;
                    result = Integer.toString(subtraction);
                    break;
                case "*":
                    int multiplication = a * b;
                    result = Integer.toString(multiplication);
                    break;
                case "/":
                    if (b != 0) {
                        int division = a / b;
                        result = Integer.toString(division);
                    } else result = "Ошибка! Деление на ноль!!!";
                    break;
                default:
                    try {
                        throw new Exception();
                    }catch (Exception e) {
                        return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
                    }
            }
            return result;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //Операнд находится за пределами от 1 до 10 включительно.";
            }
        }
    }
    //    Метод перевода римского числа в арабское число
    static int getRomeNumber(String s) {
        RomeNumber rn = RomeNumber.valueOf(RomeNumber.class, s);
        int n = rn.getNumber();
        return n;
    }
    //    Метод перевода арабского числа в римское
    static String romeName(int a) {
        RomeNumber rn2 = RomeNumber.Zero;
        for (RomeNumber element : RomeNumber.values()) {
            if (element.getNumber() == a)
                return element.getName();
        }
        return "Нет числа";
    }
}

