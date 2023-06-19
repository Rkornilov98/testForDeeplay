import java.util.*;

public class TaskTwo {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 1, 2, 4, 5, 5, 6, 2}; // Массив для примера

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        int[] mostFrequentNumbers = findMostFrequentNumbers(array);

        System.out.println("Наиболее часто встречающиеся число(числа):");
        System.out.println(Arrays.toString(mostFrequentNumbers));
    }

    // Метод для нахождения наиболее часто встречающихся чисел в массиве
    private static int[] findMostFrequentNumbers(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Добавляем в мапу элементы массива, где ключ - число, значение - количество повторений числа.
        for (int number : array) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        List<Integer> mostFrequentNumbers = new ArrayList<>();

        // Находим максимальную частоту
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        // Находим число, или числа с максимальной частотой
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == maxFrequency) {
                mostFrequentNumbers.add(number);
            }
        }

        int[] result = new int[mostFrequentNumbers.size()];
        for (int i = 0; i < mostFrequentNumbers.size(); i++) {
            result[i] = mostFrequentNumbers.get(i);
        }

        return result;
    }
}
