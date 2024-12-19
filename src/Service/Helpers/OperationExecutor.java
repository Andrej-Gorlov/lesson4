package Service.Helpers;

import Service.Implementations.CalculatorApp;
import java.math.BigDecimal;

public class OperationExecutor {

    /**
     * Выполнение арифметических операций.
     *
     * <p>Возможные операции следующие операции:</p>
     * <ul>
     *   <li>Сложение ("+") - вызывает метод {@link CalculatorApp#add(BigDecimal, BigDecimal)}</li>
     *   <li>Вычитание ("-") - вызывает метод {@link CalculatorApp#subtract(BigDecimal, BigDecimal)}</li>
     *   <li>Умножение ("*") - вызывает метод {@link CalculatorApp#multiply(BigDecimal, BigDecimal)}</li>
     *   <li>Деление ("/") - вызывает метод {@link CalculatorApp#divide(BigDecimal, BigDecimal)}</li>
     *   <li>Процент ("%") - вызывает метод {@link CalculatorApp#percent(BigDecimal, BigDecimal)}</li>
     * </ul>
     *
     * @param num1 первое число.
     * @param num2 второе число.
     */
    public static void performOperation(String command, BigDecimal num1, BigDecimal num2) {
        switch (command) {
            case "+":
                displayResult(CalculatorApp.add(num1, num2));
                break;
            case "-":
                displayResult(CalculatorApp.subtract(num1, num2));
                break;
            case "*":
                displayResult(CalculatorApp.multiply(num1, num2));
                break;
            case "/":
                try {
                    displayResult(CalculatorApp.divide(num1, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "%":
                displayResult(CalculatorApp.percent(num1, num2));
                break;
            default:
                System.out.println("Неверная операция. Пожалуйста, попробуйте снова.");
                break;
        }
    }
    private static void displayResult(BigDecimal result) {
        System.out.println("Результат: " + result);
    }
}
