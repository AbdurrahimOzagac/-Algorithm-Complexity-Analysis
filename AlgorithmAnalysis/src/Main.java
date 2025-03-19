


public class Main {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void combSort(int[] arr) {

        int gap = arr.length;
        float shrink = 1.3f;
        boolean sorted = false;
        while (!sorted) {
            gap = (int) (gap / shrink);
            sorted = (gap == 1);

            for (int i = 0; i < arr.length - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    swap(arr, i, i + gap);
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {

        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

    }

    public static void shakerSort(int[] arr) {

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < arr.length - 2; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            for (int i = arr.length - 2; i > 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void shellSort(int[] arr) {

        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
            gap = gap / 2;
        }
    }

    public static int[] radixSort(int[] arr, int d) {
        for (int pos = 1; pos <= d; pos++) {
            arr = countSort(arr, pos);
        }
        return arr;
    }

    public static int[] countSort(int[] arr, int pos) {

        int[] count = new int[10];
        int[] output = new int[arr.length];
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int digit = getDigit(arr[i],pos);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for (int i = size - 1; i >= 0; i--) {
            int digit = getDigit(arr[i], pos);
            count[digit]--;
            output[count[digit]] = arr[i];
        }

        return output;
    }
    public static int getDigit(int number, int pos) {
        return (number / (int) Math.pow(10, pos-1)) % 10;
    }


    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = {112, 31, 23, 12, 45, 11, 2, 5, 77, 1};

        array = radixSort(array,3);

        for (int idx = 0; idx < array.length; idx++) {
            System.out.print(array[idx] + ", ");
        }
        System.out.println("\n" + isSorted(array));

    }
}
