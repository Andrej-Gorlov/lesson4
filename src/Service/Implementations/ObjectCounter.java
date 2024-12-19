package Service.Implementations;

public class ObjectCounter {
    private static int objectCount = 0;
    private static boolean running = true;

    public ObjectCounter() {
        objectCount++;
    }

    /**
     * Возвращение количество объектов.
     *
     * @return количество созданных объектов.
     */
    public static int getObjectCount() {
        return objectCount;
    }

    /**
     * Запускает создания объектов.
     */
    public static void startCreatingObjects() {
        while (running) {
            new ObjectCounter();
            System.out.println("Количество созданных объектов: " + getObjectCount());
            try {
                Thread.sleep(2000); // Ждем 2 секунды
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Остановка процесса создания объектов.
    public static void stopCreatingObjects() {
        running = false;
    }

    // Сброс состояния.
    public static void reset() {
        objectCount = 0; // Сбрасываем счетчик
        running = true; // Устанавливаем флаг в true для нового запуска
    }
}
