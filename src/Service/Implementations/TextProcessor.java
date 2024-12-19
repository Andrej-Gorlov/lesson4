package Service.Implementations;

import Service.Helpers.CensorshipWords;

/**
 * Замена цензурируемых слов (реализация паттерна Singleton).
 */
public class TextProcessor {

    private static TextProcessor instance;

    private TextProcessor() {}

    /**
     * Получение единственного объекта.
     *
     * @return единственный объект.
     */
    public static TextProcessor getInstance() {
        if (instance == null) {
            instance = new TextProcessor();
        }
        return instance;
    }

    /**
     * Заменяа цензурных слов.
     *
     * @param input входная строка.
     * @return строка с замененными цензурируемыми словами (null в случае пустой входной строки).
     *
     * @throws NullPointerException входная строка содержит недопустимое значение.
     * @throws StringIndexOutOfBoundsException евыход за пределы строки.
     */
    public String replaceCensored(String input) {
        if (input == null)
            return null;

        StringBuilder result = null;

        try {
            result = new StringBuilder(input.toUpperCase());

            for (CensorshipWords word : CensorshipWords.values()) {
                // Заменяем оригинальное слово на его замену
                String originalUpper = word.getOriginal().toUpperCase();
                String replacement = word.getReplacement();

                int index = result.indexOf(originalUpper);
                while (index != -1) {
                    result.replace(index, index + originalUpper.length(), replacement);
                    index = result.indexOf(originalUpper, index + replacement.length());
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Ошибка: входная строка содержит недопустимое значение - " + e.getMessage());
            return null; // или обработка по вашему усмотрению
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Ошибка: выход за пределы строки - " + e.getMessage());
            return result != null ? result.toString() : null; // возвращаем результат, если он не null
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
            return null; // или обработка по вашему усмотрению
        }
        return result.toString();
    }
}
