package ide.api.backend.util;

public class CodeCreator {
    public static String createCppCode() {
        return "";
    }

    public static String createCorrectJavaCode() {
        return "public class Main { " +
                    "public static void main(String[] args) { " +
                        "System.out.println(\"Hello, World!\"); " +
                    "}" +
                "}";
    }
    public static String createIncorrectJavaCode() {
        return " ";
    }
}
