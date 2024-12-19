package Output;

import Service.Helpers.NumberInput;
import Service.Helpers.OperationExecutor;
import Service.Implementations.CalculatorApp;
import Service.Implementations.FinalExperiment;
import Service.Implementations.ObjectCounter;
import Service.Implementations.TextProcessor;
import java.math.BigDecimal;

public class Menu extends BaseMenu{

    public void display(){

        while (true) {

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    displayTextProcessor(TextProcessor.getInstance());
                    break;
                case 2:
                    displayFinalExperiment(FinalExperiment.getInstance());
                    break;
                case 3:
                    displayCalculatorApp();
                    break;
                case 4:
                    displayObjectCounter();
                    break;
                case 0:
                    cloceScanner();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    //region displays
    /**
     * Отображаение обработчика текста.
     *
     * @param textProcessor Объект обработки.
     *
     * @throws IllegalArgumentException неверные аргументы.
     */
    private void displayTextProcessor(TextProcessor textProcessor) {
        try {
            scn.nextLine();
            System.out.println("Введите строку:");
            String input = scn.nextLine();
            String result = textProcessor.replaceCensored(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: Неверные аргументы. " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    // Вывод экспериментов с ключевым словом final
    private void displayFinalExperiment(FinalExperiment finalExperiment) {
        finalExperiment.start();
    }

    /**
     * Запуск калькулятора.
     *
     * @throws NumberFormatException преобразование некорректного ввода в число
     */
    private void displayCalculatorApp() {
        scn.nextLine();
        String command;

        System.out.println("Вход в калькулятор");
        System.out.println("Введите 'end' для выхода из калькулятора.");

        while (true) {
            System.out.println("\nВыберите операцию: +, -, *, /, %");
            command = scn.nextLine();

            if (command.equals("end")) {
                System.out.println("Выход из калькулятора.");
                break;
            }

            if (!CalculatorApp.isOperationValid(command)) {
                System.out.println("\nВведена некорректная операция");
                continue;
            }

            BigDecimal num1 = null;
            BigDecimal num2 = null;

            try {
                num1 = NumberInput.getNumber("Введите первое число: ", scn);
                num2 = NumberInput.getNumber("Введите второе число: ", scn);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
                continue;
            }

            try {
                OperationExecutor.performOperation(command, num1, num2);
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }


    /**
     * Отображение счетчика объектов.
     *
     * @throws InterruptedException Прерывание потока.
     */
    private void displayObjectCounter() {

        System.out.println("Запуск создания объектов (ObjectCounter). ");

        scn.nextLine();
        ObjectCounter.reset();

        // Запускаем поток для создания объектов
        Thread objectCreatorThread = new Thread(ObjectCounter::startCreatingObjects);
        objectCreatorThread.start();

        // Считываем ввод пользователя
        System.out.println("Нажмите Enter для остановки создания объектов...");

        // Ожидаем ввода пользователя
        while (true) {
            String input = scn.nextLine(); // Используем nextLine для считывания строки
            if (input.isEmpty()) { // Проверяем, нажата ли клавиша Enter
                ObjectCounter.stopCreatingObjects();
                break; // Выходим из цикла
            }
        }

        // Ожидаем завершения потока
        try {
            objectCreatorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Останавливаем создание объектов
        System.out.println("Создание объектов (ObjectCounter) остановлено.");
        System.out.println("Итоговое количество созданных объектов: " + ObjectCounter.getObjectCount());
    }
    //endregion
}
