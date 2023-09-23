package ua.khpi.oop.melnik01;

public class Main {

    // Оголошення і ініціалізація змінних
    static long studentID = 0x1011; // 11 варіант
    static long phoneNumber = 380963945855L;
    static long binaryNumber = 0b110111;
    static long octalNumber = 13337;
    static long scaryNum = (11 - 1) % 26 + 1;
    static char englishLetter = (char) (scaryNum + 64);

    // Для простоти, ми зберігаємо ці змінні в масиві чисел
    static long[] numbersArray = new long[]{studentID, phoneNumber, binaryNumber, octalNumber, scaryNum, englishLetter};

    // Метод виводить кількість парних і непарних чисел у консоль
    private static void countEvenAndOdd() {
        int evenCount = 0;
        int oddCount = 0;
        // Проходимо через кожен елемент масиву чисел
        for (long num : numbersArray) {
            if (num % 2 == 0) {
                // Збільшуємо лічильник парних чисел
                evenCount++;
            } else {
                // Збільшуємо лічильник непарних чисел
                oddCount++;
            }
        }
        // Виводимо результати на консоль
        System.out.println("Even numbers: " + evenCount);
        System.out.println("Odd numbers: " + oddCount);
    }

    // Метод виводить кількість одиниць у заданих числах
    private static void numberOfOnes() {
        int count = 0;
        // Проходимо через кожен елемент масиву чисел
        for (long num : numbersArray) {
            // Перетворюємо число у рядок і визначаємо кількість одиниць у бінарному представленні
            String binaryString = Long.toBinaryString(num);
            int onesCount = 0;
            for (char digit : binaryString.toCharArray()) {
                if (digit == '1') {
                    // Збільшуємо лічильник одиниць
                    onesCount++;
                }
            }
            // Додаємо кількість одиниць до загальної кількості
            count += onesCount;
        }
        // Виводимо результат на консоль
        System.out.println("Number of ones: " + count);
    }

    // Вхідна точка програми
    public static void main(String[] args) {
        // Викликаємо методи для виведення результатів
        countEvenAndOdd();
        numberOfOnes();
    }
}
