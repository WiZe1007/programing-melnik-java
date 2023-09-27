package ua.khpi.oop.melnik05;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Завдання 1: Створення контейнера для зберігання рядків
        Container container = new Container();

        // Завдання 2: Введення тексту та операції з контейнером
        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine();

        System.out.print("Enter the length of the word to replace: ");
        int wordLength = scanner.nextInt();
        scanner.nextLine(); // Очищення буфера після введення числа

        System.out.print("Enter a string to replace: ");
        String replacement = scanner.nextLine();

        // Виклик функції для заміни слів та виведення результату
        String result = replaceWords(inputText, wordLength, replacement);

        System.out.println("Original text:");
        System.out.println(inputText);
        System.out.println("Result:");
        System.out.println(result);

        // Завдання 3: Реалізація та демонстрація методів контейнера
        container.add("One");
        container.add("Two");
        container.add("Three");
        container.clear();
        container.add("Four");
        container.remove("Two");

        System.out.println("Container contents:");
        System.out.println(container.toString());

        // Завдання 4: Демонстрація роботи ітератора за допомогою циклів
        System.out.println("Container elements using while loop:");
        Iterator<String> iterator = container.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        System.out.println("Container elements using for each loop:");
        for (String element : container) {
            System.out.println(element);
        }

        scanner.close();
    }

    // Завдання 5: Забороняється використання контейнерів (колекцій) і алгоритмів з Java Collections Framework.

    // Метод для заміни слів заданої довжини у тексті
    public static String replaceWords(String inputText, int wordLength, String replacement) {
        // Реалізація методу replaceWords
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

class Container implements Iterable<String> {
    private String[] elements;
    private int size;

    public Container() {
        elements = new String[10]; // Початковий розмір масиву
        size = 0;
    }

    @Override
    public Iterator<String> iterator() {
        return new ContainerIterator();
    }

    private class ContainerIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(String string) {
        if (size == elements.length) {
            // Збільшуємо розмір масиву, якщо потрібно
            String[] newElements = new String[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = string;
    }

    public void clear() {
        size = 0;
    }

    public boolean remove(String string) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(string)) {
                // Переміщаємо всі елементи праворуч від знайденого на одну позицію назад
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[size - 1] = null; // Очищаємо останній елемент
                size--;
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    public int size() {
        return size;
    }

    public boolean contains(String string) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Container container) {
        for (String element : container) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }
}

