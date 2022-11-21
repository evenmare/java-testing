import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private static Str userStr;

    public static boolean validateStrHasValue() {
        if (userStr != null) {
            return true;
        }

        System.out.println("Для работы функционала необходимо ввести строку!");
        start();
        return false;
    }

    public static int inputLength() {
        int length = -1;
        String errorMessage = "Введите целое число не меньше 0";

        while (length < 0) {
            length = inputNumber(errorMessage);
        }

        return length;
    }

    public static void setNewLength() {
        if (validateStrHasValue()) {
            System.out.println("Введите новую длину строки");
            int length = inputLength();

            try {
                userStr.setLength(length);
                System.out.println("Изменение длины строки завершено успешно!");
            }
            catch (Exception ex) {
                System.out.println("Изменение длины строки завершено с ошибкой:");
                System.out.println("\033[0;31m" + ex.toString() + "\033[0m");
            }

            System.out.println();
            start();
        }
    }

    public static Language inputLanguage() {
        Scanner scanner = new Scanner(System.in);

        String errorMessage = "Введите значение ENG или RUS";

        Language language;
        String languageCode = scanner.nextLine().toUpperCase();

        try {
            language = Language.valueOf(languageCode);
        }
        catch (IllegalArgumentException exception) {
            System.out.println(errorMessage);
            language = inputLanguage();
        }

        return language;
    }

    public static void setNewLanguage() {
        if (validateStrHasValue()) {
            System.out.println("Введите новый язык строки");
            Language language = inputLanguage();

            try {
                userStr.setLanguage(language);
                System.out.println("Изменение языка строки завершено успешно!");
            }
            catch (Exception ex) {
                System.out.println("Изменение языка строки завершено с ошибкой:");
                System.out.println("\033[0;31m" + ex.toString() + "\033[0m");
            }

            System.out.println();
            start();
        }
    }

    public static void inputStr() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину строки");
        int length = inputLength();

        System.out.println("Введите строку");
        char[] string = scanner.nextLine().toCharArray();

        System.out.println("Введите язык (ENG/RUS)");
        Language language = inputLanguage();

        try {
            userStr = new Str(length, string, language);
            System.out.println("Создание строки завершено успешно!");
        }
        catch (Exception ex) {
            System.out.println("Создание строки завершено с ошибкой:");
            System.out.println("\033[0;31m" + ex.toString() + "\033[0m");
        }

        System.out.println();
        start();
    }

    public static void selectStartChoice(int choiceNumber, String errorMessage) {
        switch (choiceNumber) {
            case (1):
                inputStr();
            case (2):
                setNewLength();
            case (3):
                setNewLanguage();
            case (0):
                System.exit(0);
            default:
                System.out.println(errorMessage);
                selectStartChoice(inputNumber(errorMessage), errorMessage);
        }
    }

    public static int inputNumber(String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        int choiceNumber;

        try {
            choiceNumber = scanner.nextInt();
        }
        catch (InputMismatchException exception) {
            System.out.println(errorMessage);
            choiceNumber = inputNumber(errorMessage);
        }

        return choiceNumber;
    }

    public static void getUserStartChoice() {
        String errorMessage = "Введите действительное целое число от 1 до 5\n";
        selectStartChoice(inputNumber(errorMessage), errorMessage);
    }

    public static void start() {
        System.out.println("Программа работы со строками\n");
        System.out.println("Введите вариант использования:\n" +
                "1) Инициализация строки"
        );

        if (userStr != null) {
            System.out.println(
                    "2) Установить новую длину строки\n" +
                    "3) Установить новый язык строки\n" +
                    "0) Выход из программы\n"
            );
            System.out.println(
                "Текущая строка: " +
                String.valueOf(userStr.getData()) +
                "\n"
            );
        }

        getUserStartChoice();
    }

    public static void main(String[] args) {
        start();
    }
}
