import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) throws CalculatorException {
//        System.out.println("Введите выражение");
        Scanner scanner = new Scanner(System.in);
        String calc = scanner.nextLine();
        calc = calc.replaceAll(" ", "");
        calc = calc.toUpperCase();
        String[] input = calc.split("[-+*/]");
        if (input.length == 0) {
            throw new CalculatorException("т.к. строка не является математической операцией");
        }
        if ((input[0] == "") | (input.length == 1) | calc.endsWith("+") | calc.endsWith("-") | calc.endsWith("*") | calc.endsWith("/")) {
            throw new CalculatorException("т.к. строка не является поддерживаемой математической операцией");
        }
        if (input.length > 2) {
            throw new CalculatorException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int operandCheck1;
        int operandCheck2;
        String[] inputConvert;
        inputConvert = input;
        switch (inputConvert[0]) {
            case "I" : inputConvert[0] = "1"; operandCheck1 = 1; break;
            case "1" : inputConvert[0] = "1"; operandCheck1 = 2; break;
            case "II" : inputConvert[0] = "2"; operandCheck1 = 1; break;
            case "2" : inputConvert[0] = "2"; operandCheck1 = 2; break;
            case "III" : inputConvert[0] = "3"; operandCheck1 = 1; break;
            case "3" : inputConvert[0] = "3"; operandCheck1 = 2; break;
            case "IV" : inputConvert[0] = "4"; operandCheck1 = 1; break;
            case "4" : inputConvert[0] = "4"; operandCheck1 = 2; break;
            case "V" : inputConvert[0] = "5"; operandCheck1 = 1; break;
            case "5" : inputConvert[0] = "5"; operandCheck1 = 2; break;
            case "VI" : inputConvert[0] = "6"; operandCheck1 = 1; break;
            case "6" : inputConvert[0] = "6"; operandCheck1 = 2; break;
            case "VII" : inputConvert[0] = "7"; operandCheck1 = 1; break;
            case "7" : inputConvert[0] = "7"; operandCheck1 = 2; break;
            case "VIII" : inputConvert[0] = "8"; operandCheck1 = 1; break;
            case "8" : inputConvert[0] = "8"; operandCheck1 = 2; break;
            case "IX" : inputConvert[0] = "9"; operandCheck1 = 1; break;
            case "9" : inputConvert[0] = "9"; operandCheck1 = 2; break;
            case "X" : inputConvert[0] = "10"; operandCheck1 = 1; break;
            case "10" : inputConvert[0] = "10"; operandCheck1 = 2; break;
            default:
                throw new CalculatorException("т.к. калькулятор работает только с целыми римскими цифрами от I до X включительно или только с целыми арабскими цифрами от 1 до 10 включительно");
        }
        switch (inputConvert[1]) {
            case "I" : inputConvert[1] = "1"; operandCheck2 = 1; break;
            case "1" : inputConvert[1] = "1"; operandCheck2 = 2; break;
            case "II" : inputConvert[1] = "2"; operandCheck2 = 1; break;
            case "2" : inputConvert[1] = "2"; operandCheck2 = 2; break;
            case "III" : inputConvert[1] = "3"; operandCheck2 = 1; break;
            case "3" : inputConvert[1] = "3"; operandCheck2 = 2; break;
            case "IV" : inputConvert[1] = "4"; operandCheck2 = 1; break;
            case "4" : inputConvert[1] = "4"; operandCheck2 = 2; break;
            case "V" : inputConvert[1] = "5"; operandCheck2 = 1; break;
            case "5" : inputConvert[1] = "5"; operandCheck2 = 2; break;
            case "VI" : inputConvert[1] = "6"; operandCheck2 = 1; break;
            case "6" : inputConvert[1] = "6"; operandCheck2 = 2; break;
            case "VII" : inputConvert[1] = "7"; operandCheck2 = 1; break;
            case "7" : inputConvert[1] = "7"; operandCheck2 = 2; break;
            case "VIII" : inputConvert[1] = "8"; operandCheck2 = 1; break;
            case "8" : inputConvert[1] = "8"; operandCheck2 = 2; break;
            case "IX" : inputConvert[1] = "9"; operandCheck2 = 1; break;
            case "9" : inputConvert[1] = "9"; operandCheck2 = 2; break;
            case "X" : inputConvert[1] = "10"; operandCheck2 = 1; break;
            case "10" : inputConvert[1] = "10"; operandCheck2 = 2; break;
            default:
                throw new CalculatorException("т.к. калькулятор работает только с целыми римскими цифрами от I до X включительно или только с целыми арабскими цифрами от 1 до 10 включительно");
        }
        int[] inputEdited = new int[2];
        for (int i = 0; i < input.length; i++) {
            inputEdited[i] = Integer.parseInt(inputConvert[i]);
        }
            if (operandCheck1 != operandCheck2) {
                throw new CalculatorException("т.к. используются одновременно разные системы счисления");
            }
        int answer = 0;
            if (calc.indexOf(43) > -1) {
                answer = inputEdited[0] + inputEdited[1];
            } else if (calc.indexOf(45) > -1) {
                answer = inputEdited[0] - inputEdited[1];
            } else if (calc.indexOf(42) > -1) {
                answer = inputEdited[0] * inputEdited[1];
            } else if (calc.indexOf(47) > -1) {
                answer = inputEdited[0] / inputEdited[1];
            }
        if (((operandCheck1 == 1) & (operandCheck2 == 1)) & (answer < 1)) {
            throw new CalculatorException("т.к. в римской системе нет отрицательных чисел и нуля");
        }
        String[] answerRoman = new String[] {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
//        System.out.println("Ответ");
        if ((operandCheck1 == 1) & (operandCheck2 == 1)) {
            System.out.print(answerRoman[answer]);
        } else System.out.print(answer);
    }
}