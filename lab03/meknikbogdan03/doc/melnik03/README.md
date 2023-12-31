## Лабораторна робота № 3. Утилітарні класи. Обробка масивів і рядків

**Розробник:**  Мельник Б.В.Група:КН-922в. 

## Мета
Розробка власних утилітарних класів.
Набуття навичок вирішення прикладних задач з використанням масивів і рядків.


## ВИМОГИ

1. Розробити та продемонструвати консольну програму мовою Java в середовищі Eclipse для вирішення прикладної задачі за номером, що відповідає збільшеному на одиницю залишку від ділення на 15 зменшеного на одиницю номера студента в журналі групи.

2. При вирішенні прикладних задач використовувати латинку.

3. Продемонструвати використання об'єктів класу StringBuilder або StringBuffer.

4. Застосувати функціональну (процедурну) декомпозицію - розробити власні утилітарні класи (особливий випадок допоміжного класу, див. Helper Class) та для обробки даних використовувати відповідні статичні методи.

5. Забороняється використовувати засоби обробки регулярних виразів: класи пакету java.util.regex (Pattern, Matcher та ін.), а також відповідні методи класу String (matches, replace, replaceFirst, replaceAll, split).


## Прикладні задачі

1. Знайти найбільший спільний дільник двох цілих позитивних чисел.

## ОПИС ПРОГРАМИ

### Функціональне призначення

Функціональне призначення даної програми полягає в наступному:

Ця програма дозволяє користувачеві ввести текст, довжину слова для заміни та рядок для заміни. Після введення цих даних програма використовує функцію replaceWords для обробки введеного тексту. Функція replaceWords замінює слова у тексті, які мають вказану довжину, на заданий рядок для заміни. Після обробки тексту програма виводить початковий текст і результат заміни на екран.

Основна функціональність програми включає в себе наступні кроки:

1. Введення тексту від користувача.
2. Введення довжини слова для заміни та рядка для заміни.
3. Виклик функції replaceWords для заміни слів у введеному тексті.
4. Виведення початкового тексту та тексту зі здійсненою заміною на екран.

Отже, основною метою програми є обробка тексту, заміна слів заданої довжини на інший рядок і виведення результату.

### Засоби ООП

 - Java code convention;
 - JDK;
 - java.util.Scanner.

### Ієрархія та структура класів

У даній програмі ієрархія та структура класів виглядають наступним чином:

1. Main клас:
   - Основний клас програми, який містить метод main.
   - Відповідає за взаємодію з користувачем та виклик інших методів.
2. Метод main:
   - Викликається при запуску програми.
   - Відповідає за взаємодію з користувачем, введення даних, і виведення результату.
3. Метод replaceWords:
   - Метод, який виконує заміну слів у введеному тексті.
   - Приймає вхідні параметри: inputText (введений текст), wordLength (довжина слова для заміни), та replacement (рядок для заміни).
   - Використовується для обробки тексту та повернення тексту із виконаною заміною.
   
Ця програма має просту структуру, в якій Main клас відповідає за взаємодію з користувачем, а метод replaceWords виконує фактичну обробку тексту. Така організація дозволяє виділити функціональність заміни слів у власний метод для більшої чіткості і перевикористання коду.

### Важливі фрагменти програми


```
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

```

## Структура програми

```

├── lab03
    ├── bin
    │   └── ua
    │       └── khpi
    │           └── oop
    └── meknikbogdan03
        ├── doc
        │   └── melnik03
        │       └── README.md
        └── src
              └── ua
                  └── khpi
                      └── oop
                         └── melnik03
                              ├── Main.java
                              └── package-info.java


```

## ВАРІАНТИ ВИКОРИСТАННЯ

## ВАРІАНТИ ВИКОРИСТАННЯ

- дебагер lldb:
```
Enter the text: Hello world! Programming is interesting and you can earn a lot with it 
Enter the length of the word to replace: 4
Enter a string to replace: World
Original text:
Hello world! Programming is interesting and you can earn a lot with it
Result:
Hello world! Programming is interesting and you can World a lot World it
bogdan@bogdan-VirtualBox:~/programing-melnik-java/lab03/meknikbogdan03/src/ua/khpi/oop/melnik03$ 
```
- консоль;
- дебагер gdb;


## ВИСНОВОК 

В даній лабораторній роботі я навчився розробляти власні утилітарні класи. Набув навичок вирішення прикладних задач з використання масивів і рядків





















