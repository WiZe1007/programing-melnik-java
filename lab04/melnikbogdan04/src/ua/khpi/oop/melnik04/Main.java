import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Створення об'єкту Scanner для зчитування введення користувача з консолі.

        if (args.length > 0) { // Перевірка, чи є аргументи командного рядка.
            for (String arg : args) {
                if (arg.equals("-h") || arg.equals("-help")) {
                    printHelp(); // Виклик методу printHelp() для відображення довідки та завершення програми.
                    return;
                } else if (arg.equals("-d") || arg.equals("-debug")) {
                    debugMode = true; // Встановлення режиму налагодження (debug), якщо користувач передав аргумент -d або -debug.
                }
            }
        }

        boolean exit = false; // Флаг для виходу з програми.
        String inputText = ""; // Змінна для збереження введеного тексту.
        int wordLength = 0; // Довжина слова, яку користувач вказує для заміни.
        String replacement = ""; // Рядок, який користувач вказує для заміни.

        while (!exit) { // Головний цикл програми.
            System.out.println("Меню:");
            System.out.println("1. Введення даних");
            System.out.println("2. Перегляд даних");
            System.out.println("3. Виконання обчислень");
            System.out.println("4. Відображення результату");
            System.out.println("5. Завершення програми");
            System.out.print("Оберіть опцію (1-5): ");

            int choice = scanner.nextInt(); // Зчитування вибору користувача.
            scanner.nextLine(); // Очищення буфера введення.

            switch (choice) {
                case 1:
                    System.out.print("Enter the text: ");
                    inputText = scanner.nextLine();
                    System.out.print("Enter the length of the word to replace: ");
                    wordLength = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter a string to replace: ");
                    replacement = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Введений текст:");
                    System.out.println(inputText);
                    System.out.println("Довжина слова для заміни: " + wordLength);
                    System.out.println("Рядок для заміни: " + replacement);
                    break;
                case 3:
                    String result = replaceWords(inputText, wordLength, replacement); // Виклик методу для обробки тексту.
                    inputText = result;
                    System.out.println("Результат обчислень:");
                    System.out.println(result);
                    break;
                case 4:
                    System.out.println("Результат:");
                    System.out.println(inputText);
                    break;
                case 5:
                    System.out.println("Програма завершена.");
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір опції. Будь ласка, спробуйте ще раз.");
            }
        }

        scanner.close(); // Закриття об'єкту Scanner.
    }

    public static String replaceWords(String inputText, int wordLength, String replacement) {
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            if (Character.isLetter(c)) {
                currentWord.append(c); // Додавання символу до поточного слова.
            } else {
                if (currentWord.length() == wordLength) {
                    resultBuilder.append(replacement); // Заміна слова, якщо воно має вказану довжину.
                } else {
                    resultBuilder.append(currentWord); // Додавання поточного слова до результату.
                }
                resultBuilder.append(c); // Додавання роздільника (не букви) до результату.
                currentWord.setLength(0); // Очищення поточного слова для наступного циклу.
            }
        }

        if (currentWord.length() == wordLength) {
            resultBuilder.append(replacement); // Заміна останнього слова, якщо воно має вказану довжину.
        } else {
            resultBuilder.append(currentWord); // Додавання останнього слова до результату.
        }

        return resultBuilder.toString(); // Повернення результату обробки тексту.
    }

    public static void printHelp() {
        System.out.println("Лабораторна робота №3");
        System.out.println("Мета: Реалізація діалогового режиму роботи з користувачем в консольних програмах мовою Java.");
        System.out.println("Параметри командного рядка:");
        System.out.println("-h, -help - відображає цей довідник");
        System.out.println("-d, -debug - включає режим налагодження (debug)");
    }

    private static boolean debugMode = false; // Флаг для включення режиму налагодження (debug).
}

