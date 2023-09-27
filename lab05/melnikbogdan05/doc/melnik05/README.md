## Лабораторна робота № 5. Розробка власних контейнерів. Ітератори

**Розробник:**  Мельник Б.В. Група:КН-922в. 

## Мета

 - Набуття навичок розробки власних контейнерів.
 - Використання ітераторів.

## ВИМОГИ ТА ПРИКЛАДНІ ЗАДАЧІ

1. Розробити клас-контейнер, що ітерується для збереження початкових даних завдання л.р. №3 у вигляді масиву рядків з можливістю додавання, видалення і зміни елементів.

2. В контейнері реалізувати та продемонструвати наступні методи:

   - String toString() повертає вміст контейнера у вигляді рядка;
   - void add(String string) додає вказаний елемент до кінця контейнеру;
   - void clear() видаляє всі елементи з контейнеру;
   - boolean remove(String string) видаляє перший випадок вказаного елемента з контейнера;
   - Object[] toArray() повертає масив, що містить всі елементи у контейнері;
   - int size() повертає кількість елементів у контейнері;
   - boolean contains(String string) повертає true, якщо контейнер містить вказаний елемент;
   - boolean containsAll(Container container) повертає true, якщо контейнер містить всі елементи з зазначеного у параметрах;
   - public Iterator<String> iterator() повертає ітератор відповідно до Interface Iterable.
   
3. В класі ітератора відповідно до Interface Iterator реалізувати методи:

   - public boolean hasNext();
   - public String next();
   - public void remove().
   
4. Продемонструвати роботу ітератора за допомогою циклів while и for each.

5. Забороняється використання контейнерів (колекцій) і алгоритмів з Java Collections Framework.


## ОПИС ПРОГРАМИ

### Функціональне призначення

Ця програма має декілька функціональних призначень:

1. Створення контейнера для зберігання рядків: В програмі створюється клас Container, який використовується для зберігання рядків у внутрішньому масиві. Цей контейнер має методи для додавання, видалення, очищення, перевірки наявності та інших операцій над рядками.

2. Заміна слів заданої довжини у тексті: В програмі є метод replaceWords, який призначений для заміни слів заданої довжини у введеному тексті. Він приймає на вхід текст, довжину слова для заміни та рядок для заміни, а потім замінює всі слова заданої довжини у тексті на вказаний рядок.

3. Реалізація та демонстрація методів контейнера: Програма демонструє роботу методів контейнера, таких як додавання, видалення, очищення та інші операції над рядками у контейнері. Це демонструється у функції main, де виконуються різні операції з контейнером.

4. Демонстрація роботи ітератора: Програма також демонструє роботу ітератора для обходу елементів контейнера. Це робиться за допомогою циклів while та for each.

5. Заборона використання контейнерів Java Collections Framework: Програма має обмеження на використання контейнерів та алгоритмів з Java Collections Framework, і вона реалізовує власний контейнер для зберігання рядків та відповідні операції.

Отже, функціональне призначення програми полягає в тому, щоб створити, продемонструвати та протестувати контейнер для зберігання рядків, реалізувати метод для заміни слів у тексті, а також продемонструвати роботу ітератора для обходу елементів цього контейнера.

### Засоби ООП

  - Java code convention;
  - JDK;
  - java.util.Iterator;
  - java.util.NoSuchElementException
  - java.util.Scanner;
  - java.util.Objects;
  - java.util.*.


### Ієрархія та структура класів

У програмі є декілька класів з різними завданнями. Ось ієрархія та структура класів у цій програмі:

1. Main - це клас, який містить метод main, який є точкою входу в програму. В цьому класі ви викликаєте інші класи та методи для виконання завдань програми.

2. Container - це клас для створення контейнера для зберігання рядків. Він реалізує інтерфейс Iterable<String>, що дозволяє використовувати ітератор для перебору елементів контейнера.

3. ContainerIterator - це внутрішній клас, який реалізує інтерфейс Iterator<String> для ітерації по елементах контейнера.

Таким чином, ієрархія класів виглядає так:

- Main
  - Container
    - ContainerIterator
    
Загальна структура класів:

- Main: містить точку входу в програму, викликає методи для зчитування введення користувача та виконання різних завдань.
- Container: створює та управляє контейнером для зберігання рядків, реалізує інтерфейс Iterable<String> для ітерації по рядках у контейнері.
- ContainerIterator: реалізує інтерфейс Iterator<String>, щоб дозволити ітерацію по рядках у контейнері.

Додатково, в програмі є метод replaceWords в класі Main, який виконує заміну слів заданої довжини у тексті. Цей метод не є частиною ієрархії класів, але він викликається з методу main для виконання певного завдання.

### Важливі фрагменти програми


```
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

```

## Структура програми

```

├── lab05
    ├── bin
    │   ├── Container$ContainerIterator.class
    │   ├── Container.class
    │   ├── Main.class
    │   └── ua
    │       └── khpi
    │           └── oop
    └── melnikbogdan05
        ├── doc
        │   └── melnik05
        │       └── README.md
        └── src
            └── ua
                └── khpi
                    └── oop
                        └── melnik05
                            ├── Main.java
                            └── package-info.java

```

## ВАРІАНТИ ВИКОРИСТАННЯ

## ВАРІАНТИ ВИКОРИСТАННЯ

- дебагер lldb:
```
Enter the text: Hello world
Enter the length of the word to replace: 5
Enter a string to replace: Hi
Original text:
Hello world
Result:
Hi Hi
Container contents:
[Four]
Container elements using while loop:
Four
Container elements using for each loop:
Four
```
- консоль:
- дебагер gdb;


## ВИСНОВОК 

В даній лабораторній роботі я набув навичок розробки власних контейнерів. Використав ітератори. Виконав Прикладні завдання






















