
import java.io.*;
import java.util.*;

public class Main {

    // read CSV file and return data in 3rd column
    public static int[] readCSV(String filePath, int limit) throws IOException {
        List<Integer> data = new ArrayList<>(); // Verileri tutacak liste
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        int lineCount = 0;

        while ((line = reader.readLine()) != null && data.size() < limit) {
            lineCount++;
            if (lineCount == 1)
                continue; // Başlık satırını atla (Eğer başlık varsa)

            String[] columns = line.split(","); // Satırı virgüllerle ayır
            if (columns.length >= 3) { // En az 3 sütun olduğundan emin ol
                try {
                    int value = Integer.parseInt(columns[2].trim()); // 3. sütundaki değeri al
                    data.add(value); // Listeye ekle
                } catch (NumberFormatException e) {
                    System.out.println("Hatalı veri: " + columns[2]);
                }
            }
        }

        reader.close();

        // Listeyi diziye dönüştür
        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] reverseArray(int[] origin) {

        int[] arr = origin.clone();
        int left = 0;
        int right = arr.length - 1;
    
        // Swap elements from both ends towards the center
        while (left < right) {
            // Swap the elements at left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
    
            // Move towards the center
            left++;
            right--;
        }

        return arr;
    }

    public static boolean isReverseSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }

        }
        return true;
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

        try {

            // Read data from the file and store it in the fullData array
            String filePath = "TrafficFlowDataset.csv";
            int[] fullData = readCSV(filePath, 250000);

            //Random data test
            Testing.FullTest("Random data", fullData);

            //Sort the fullData and check
            int[] sortedFullData = SortingAlgorithms.radixSort(fullData);

            if (!isSorted(sortedFullData))
                System.out.println("ERROR: sortedFullData is not sorted!!");
            else {
                System.out.println("OK: sortedFullData is sorted succsesfully!");
            }

            //Sorted data test
            Testing.FullTest("Sorted data", sortedFullData);

            //Reverse sort fullData and check
            int[] reversedFullData = reverseArray(sortedFullData);
            
            if (!isReverseSorted(reversedFullData)) {
                System.out.println("ERROR: reversedFullData is not reverse sorted!!");
            } else {
                System.out.println("OK: reversedFullData is reverse sorted successfully!");
            }
        
            //Reverse sorted data test
            Testing.FullTest("Reverse sorted data", reversedFullData);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
