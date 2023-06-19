import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskFour {
    public static void main(String[] args) {
        int[] numbers = {17, 12, 10, 4, 9, 8}; // Массив для примера.
        int numGroups = 2; // Кол-во групп для примера.

        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        System.out.println("Количество групп: " + numGroups);

        List<List<Integer>> result = distributeNumbers(numbers, numGroups);

        if (result == null) {
            System.out.println("Невозможно");
        } else {
            System.out.println("Результаты:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Группа " + (i + 1) + ": " + result.get(i));
            }
        }
    }

    private static List<List<Integer>> distributeNumbers(int[] numbers, int numGroups) {
        int totalSum = Arrays.stream(numbers).sum();
        if (totalSum % numGroups != 0) {
            return null; // Невозможно распределить массив на группы по сумме
        }

        int targetSum = totalSum / numGroups;
        List<List<Integer>> result = new ArrayList<>();
        int[] groupSums = new int[numGroups];
        for (int i = 0; i < numGroups; i++) {
            result.add(new ArrayList<>()); // Создаем пустой список для каждой группы
        }

        boolean success = distribute(numbers, 0, groupSums, targetSum, result);

        if (success) {
            return result;
        } else {
            return null; // Невозможно распределить числа на группы с равными суммами
        }
    }

    private static boolean distribute(int[] numbers, int index, int[] groupSums, int targetSum, List<List<Integer>> result) {
        if (index == numbers.length) {
            return true;
        }

        int currentNumber = numbers[index];
        for (int i = 0; i < groupSums.length; i++) {
            if (groupSums[i] + currentNumber <= targetSum) {
                groupSums[i] += currentNumber;
                result.get(i).add(currentNumber);

                if (distribute(numbers, index + 1, groupSums, targetSum, result)) {
                    return true;
                }

                groupSums[i] -= currentNumber;
                result.get(i).remove(result.get(i).size() - 1);
            }
        }

        return false; // Невозможно распределить число в текущей группе
    }
}