package Service.Helpers;

/**
 * Перечисление подлежащие цензуре.
 */
public enum CensorshipWords {
    BYAKA("БЯКА", "вырезано цензурой"),
    DURAK("ДУРАК", "вырезано цензурой"),
    DURA("ДУРА", "вырезано цензурой");

    private final String original; // Оригинальное слово
    private final String replacement; // Замена для оригинального слова

    CensorshipWords(String original, String replacement) {
        this.original = original;
        this.replacement = replacement;
    }

    /**
     * @return Оригинальное слово
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @return Замена для оригинального слова
     */
    public String getReplacement() {
        return replacement;
    }
}
