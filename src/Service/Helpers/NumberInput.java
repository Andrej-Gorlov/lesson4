package Service.Helpers;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberInput {

    /**
     * Запрос у пользователя ввода числа.
     *
     * @param prompt сообщение пользователю перед вводом числа.
     * @param scn Scanner
     * @return введенное пользователем число.
     */
    public static BigDecimal getNumber(String prompt, Scanner scn) {
        BigDecimal number = null;
        while (number == null) {
            System.out.print(prompt);
            try {
                number = scn.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
                scn.nextLine(); // очистка некорректного ввода
            }
        }
        scn.nextLine(); // очистка буфера после ввода числа
        return number;
    }
}
