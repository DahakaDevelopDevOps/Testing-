import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);
    static int maxInt = Integer.MAX_VALUE;
    static int minInt = Integer.MIN_VALUE;
    static boolean startAgain = true;

    public static void main(String[] args) {

        try {
            while (startAgain) {
                System.out.println("Enter integer number:");
                int firstNumber = scanner.nextInt();
                System.out.println("Enter integer number:");
                int secondNumber = scanner.nextInt();
                char operation = getOperation();
                int result = calculate(firstNumber, secondNumber, operation);
                System.out.println("Result: "+ result+ "Start again(0 - Y, other - N)");
                String stringFlag = scanner.next();
                startAgain = startAgain(stringFlag);
            }
        } catch (Exception e ) {
            System.out.println("Error!!! Enter what had been asked");
        }

    }

    public static boolean startAgain(String flag) throws IllegalArgumentException {
        if (flag != "0") return false;
        else return true;
    }

    public static char getOperation() {
        System.out.println("Enter operation:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else operation = getOperation();
        return operation;
    }

    public static int calculate(int firstNumber, int secondNumber, char operation) throws ArithmeticException {
        int result;
        switch (operation) {
            case '+':
                result = add(firstNumber, secondNumber);
                break;
            case '-':
                result = subtract(firstNumber, secondNumber);
                break;
            case '*':
                result = multiply(firstNumber, secondNumber);
                break;
            case '/':
                result = divide(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculate(firstNumber, secondNumber, getOperation());
        }
        return result;
    }

    public static int add(int firstNumber, int secondNumber) throws ArithmeticException  {
        if (firstNumber > 0 && secondNumber > 0 && firstNumber > (maxInt - secondNumber) || ((long) firstNumber + secondNumber < minInt)) throw new ArithmeticException("Переполнение int в результате сложения.");
        return firstNumber + secondNumber;
    }

    public static int subtract(int firstNumber, int secondNumber) throws ArithmeticException {
        if ((secondNumber > 0 && firstNumber < minInt + secondNumber) || (secondNumber < 0 && firstNumber > minInt + secondNumber) || ((long) firstNumber - secondNumber > maxInt)) throw new ArithmeticException("Переполнение int в результате вычитания.");
         else
            return firstNumber - secondNumber;
    }

    public static int multiply(int firstNumber, int secondNumber) throws ArithmeticException {
        long PreResult = (long) firstNumber * secondNumber;
        if (PreResult > Integer.MAX_VALUE || PreResult < Integer.MIN_VALUE) throw new ArithmeticException("Переполнение int в результате умножения.");
        return firstNumber * secondNumber;
    }

    public static int divide(int firstNumber, int secondNumber) throws ArithmeticException {
        long PreResult = (long) firstNumber / secondNumber;
        if (PreResult > Integer.MAX_VALUE || PreResult < Integer.MIN_VALUE)  throw new ArithmeticException("Переполнение int в результате деления.");
        if (secondNumber == 0) throw new ArithmeticException("Деление на 0");
        return firstNumber / secondNumber;
    }
}