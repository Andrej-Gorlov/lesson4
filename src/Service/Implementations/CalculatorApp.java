package Service.Implementations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Калькулятор
 */
public class CalculatorApp {

    /**
     * Сложение.
     * @param a первое число
     * @param b второе число
     * @return сумма чисел
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    /**
     * Вычитание.
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return результат вычитания
     */
    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    /**
     * Умножение.
     * @param a первое число (не может быть null)
     * @param b второе число (не может быть null)
     * @return произведение чисел
     * @throws IllegalArgumentException равен null
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Параметры не могут быть null.");
        }
        return a.multiply(b);
    }

    /**
     * Деление.
     * @param a делимое (не может быть null)
     * @param b делитель (не может быть null и не должен быть равен нулю)
     * @return результат деления a на b
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        validateNotNull(a, b);
        if (b.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно.");
        }
        // Возвращаем результат деления a на b с округлением
        return a.divide(b, RoundingMode.HALF_UP);
    }

    /**
     * Вычисление процентов.
     *
     * @param a число (не может быть null)
     * @param percentage процент (не может быть null и не должен быть отрицательным)
     * @return вычисленный процент
     */
    public static BigDecimal percent(BigDecimal a, BigDecimal percentage) {
        validateNotNull(a, percentage);
        if (percentage.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Процент не может быть отрицательным.");
        }
        return a.multiply(percentage).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }

    public static Boolean isOperationValid (String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("%");
    }

    /**
     * Проверка на null.
     * @param a первое число
     * @param b второе число
     * @throws IllegalArgumentException если любой из параметров равен null
     */
    private static void validateNotNull(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Параметры не могут быть null.");
        }
    }
}