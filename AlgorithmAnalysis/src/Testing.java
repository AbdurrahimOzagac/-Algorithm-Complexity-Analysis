import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Testing {

    public static long Test(int[] data, Consumer<int[]> sortingMethod) {

        long totalDuration = 0;

        for (int i = 0; i < 10; i++) {

            int[] copy = data.clone();
            
            long startTime = System.currentTimeMillis();
            sortingMethod.accept(copy);
            long endTime = System.currentTimeMillis();

            totalDuration += endTime - startTime;
        }

        return totalDuration / 10;
    }

    public static long TestRadix(int[] data, Function<int[], int[]> sortingMethod) {
        long totalDuration = 0;

        for (int i = 0; i < 10; i++) {
            int[] copy = data.clone();

            long startTime = System.currentTimeMillis();
            sortingMethod.apply(copy);
            long endTime = System.currentTimeMillis();

            totalDuration += endTime - startTime;
        }

        return totalDuration / 10;
    }

    public static void FullTest(String type, int[] fullData) {

        int[] testSize = { 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000 };

        long[] insertionTimes = new long[testSize.length];
        long[] combTimes = new long[testSize.length];
        long[] shakerTimes = new long[testSize.length];
        long[] shellTimes = new long[testSize.length];
        long[] radixTimes = new long[testSize.length];

        for (int j = 0; j < testSize.length; j++) {
            
            int size = testSize[j];
            int[] data = Arrays.copyOfRange(fullData, 0, size);

            insertionTimes[j] = Testing.Test(data, SortingAlgorithms::insertionSort);
            combTimes[j] = Testing.Test(data, SortingAlgorithms::combSort);
            shakerTimes[j] = Testing.Test(data, SortingAlgorithms::shakerSort);
            shellTimes[j] = Testing.Test(data, SortingAlgorithms::shellSort);
            radixTimes[j] = Testing.TestRadix(data, SortingAlgorithms::radixSort);
        }

        System.out.println("Insertion Sort Times: " + Arrays.toString(insertionTimes));
        System.out.println("Comb Sort Times: " + Arrays.toString(combTimes));
        System.out.println("Shaker Sort Times: " + Arrays.toString(shakerTimes));
        System.out.println("Shell Sort Times: " + Arrays.toString(shellTimes));
        System.out.println("Radix Sort Times: " + Arrays.toString(radixTimes));
    }
}
