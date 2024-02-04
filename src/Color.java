public enum Color {

    ANSI_RED("\u001B[31m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_PINk("\u001B[35m"),
    ANSI_RESET("\u001B[0m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getColor() {
        return code;
    }

}
