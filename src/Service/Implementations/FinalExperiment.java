package Service.Implementations;

/**
 * Эксперимент с ключевым словом final (реализация паттерна Singleton).
 */
public class FinalExperiment {

    private static FinalExperiment instance;

    private FinalExperiment() {}

    /**
     * Получение единственного объекта.
     *
     * @return единственный объект.
     */
    public static FinalExperiment getInstance() {
        if (instance == null) {
            instance = new FinalExperiment();
        }
        return instance;
    }

    public void start() {
        String[] examples = {
                "1) final int constantValue = 10;\n" +
                        "   System.out.println(\"Значение постоянной: \" + constantValue);\n" +
                        "   constantValue = 20; - вызовет ошибку компиляции, так как final переменная не может быть изменена.",

                "2) class BaseClass {\n" +
                        "       public final void display() {\n" +
                        "           System.out.println(\"Это финальный метод.\");\n" +
                        "       }\n" +
                        "   }\n" +
                        "   class SubClass extends BaseClass {\n" +
                        "        public void display() { - вызовет ошибку компиляции, так как метод не может быть переопределен.\n" +
                        "            System.out.println(\"Переопределение финального метода.\");\n" +
                        "        }\n" +
                        "   }\n" +
                        "   public class FinalMethodExample {\n" +
                        "       public static void main(String[] args) {\n" +
                        "           BaseClass obj = new SubClass();\n" +
                        "           obj.display();\n" +
                        "       }\n" +
                        "   }",

                "3) final class FinalClass {\n" +
                        "       public void show() {\n" +
                        "           System.out.println(\"Это финальный класс.\");\n" +
                        "       }\n" +
                        "   }\n" +
                        "    class SubClass extends FinalClass { - вызовет ошибку компиляции, так как класс не может быть расширен.\n" +
                        "    }\n" +
                        "   public class FinalClassExample {\n" +
                        "       public static void main(String[] args) {\n" +
                        "           FinalClass obj = new FinalClass();\n" +
                        "           obj.show();\n" +
                        "       }\n" +
                        "   }",

                "4) public class FinalArrayExample {\n" +
                        "       public static void main(String[] args) {\n" +
                        "           final int[] numbers = {1, 2, 3};\n" +
                        "           System.out.println(\"Первый элемент: \" + numbers[0]);\n" +
                        "           Изменение элементов массива допустимо\n" +
                        "           numbers[0] = 10;\n" +
                        "           System.out.println(\"После изменения: \" + numbers[0]);\n" +
                        "           numbers = new int[]{4, 5, 6}; // - вызовет ошибку компиляции, так как ссылка не может быть изменена.\n" +
                        "       }\n" +
                        "   }",

                "5) public class FinalParameterExample {\n" +
                        "       public static void display(final int value) {\n" +
                        "           value = 20; - вызовет ошибку компиляции, так как final параметр не может быть изменен.\n" +
                        "           System.out.println(\"Значение: \" + value);\n" +
                        "       }\n" +
                        "       public static void main(String[] args) {\n" +
                        "           display(10);\n" +
                        "       }\n" +
                        "   }"
        };

        for (String example : examples) {
            System.out.println(example);
            System.out.println();
        }
    }
}