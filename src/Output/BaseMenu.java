package Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseMenu {
    protected final Scanner scn;

    protected void cloceScanner(){
        this.scn.close();
    }
    
    public BaseMenu(){
        this.scn = new Scanner(System.in);
    }

    public int getUserChoice() {
        while (true) {
            try {
                menuDefault();
                return this.scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое число.");
                this.scn.next(); // Очистка неверного ввода
            }
        }
    }

    private  void menuDefault(){
        System.out.println("\n 1) Проверка текста на цензуру.");
        System.out.println(" 2) Вывод экспериментов с ключевым словом final");
        System.out.println(" 3) Калькулятор");
        System.out.println(" 4) Счетчик количества создаваемых объектов");
        System.out.println(" 0) Выход \n");
    }
}
