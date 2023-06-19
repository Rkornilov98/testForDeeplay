import java.util.Arrays;
import java.util.Random;

public class TaskOne {

    public static void main(String[] args) {
        int[] array = generateArray(10); // Для примера: массив из 10 чисел.

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));



        System.out.println("Изменённый массив:");
        System.out.println(Arrays.toString(reorderArray(array)));
    }

    // Метод для заполнения массива
    private static int[] generateArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    // Метод для переупорядочивания массива
    private static int[] reorderArray(int[] array) {
        Arrays.sort(array);

        int[] result = new int[array.length];
        int odd = 0;
        int even = array.length - 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                result[odd] = array[i];
                odd++;
            } else if (array[i] == 0) {
                result[even] = array[i];
                even--;
            } else {
                result[even] = array[i];
                even--;
            }
        }

        return result;
    }
}
