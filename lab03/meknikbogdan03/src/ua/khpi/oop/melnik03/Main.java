/*
Завдання:
Розробити та продемонструвати консольну програму мовою Java в середовищі Eclipse для вирішення прикладної задачі за номером, що відповідає збільшеному на одиницю залишку від ділення на 15 зменшеного на одиницю номера студента в журналі групи.

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    // Створюємо об'єкт Scanner для зчитування введення з консолі
    Scanner scanner = new Scanner(System.in);

    // Запитуємо користувача ввести номер студента
    System.out.print("Введіть номер студента в журналі групи: ");
        
    // Зчитуємо введений номер студента
    int studentNumber = scanner.nextInt();

    // Обчислюємо результат виразу
    int result = (studentNumber + 1) % 15 - 1;

    // Виводимо результат на консоль
    System.out.println("Результат: " + result);

    // Закриваємо Scanner
    scanner.close();
 }
}
*/



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення тексту
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();

        // Введення довжини слова для заміни
        System.out.print("Enter the length of the word to replace: ");
        int wordLength = scanner.nextInt();
        scanner.nextLine(); // Очищення буфера після введення числа

        // Введення рядка для заміни
        System.out.print("Enter a string to replace: ");
        String replacement = scanner.nextLine();

        // Викликаємо функцію для заміни слів та виведення результату
        String result = replaceWords(inputText, wordLength, replacement);

        System.out.println("Original text:");
        System.out.println(inputText);
        System.out.println("Result:");
        System.out.println(result);

        scanner.close();
    }

    // Метод для заміни слів заданої довжини у тексті
    public static String replaceWords(String inputText, int wordLength, String replacement) {
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (char c : inputText.toCharArray()) {
            if (Character.isLetter(c)) {
                // Додаємо літеру до поточного слова
                currentWord.append(c);
            } else {
                // Завершуємо поточне слово і перевіряємо його довжину
                if (currentWord.length() == wordLength) {
                    resultBuilder.append(replacement);
                } else {
                    resultBuilder.append(currentWord);
                }
                resultBuilder.append(c);
                currentWord.setLength(0); // Очищаємо поточне слово
            }
        }

        // Обробка останнього слова у тексті
        if (currentWord.length() == wordLength) {
            resultBuilder.append(replacement);
        } else {
            resultBuilder.append(currentWord);
        }

        return resultBuilder.toString();
    }
}










