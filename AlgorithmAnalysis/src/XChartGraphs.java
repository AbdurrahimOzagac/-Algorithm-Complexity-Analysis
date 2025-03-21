import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.None;
import java.io.IOException;

public class XChartGraphs {

    private static final int[] dataSizes = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};

    // Random Input Data
    private static final int[] insertionSortTimes = {0, 0, 1, 6, 25, 108, 397, 1538, 6335, 27265};
    private static final int[] combSortTimes = {0, 0, 0, 0, 0, 1, 3, 6, 15, 30};
    private static final int[] shakerSortTimes = {1, 1, 2, 8, 34, 145, 526, 3422, 19287, 90782};
    private static final int[] shellSortTimes = {0, 0, 0, 0, 1, 2, 5, 11, 27, 47};
    private static final int[] radixSortTimes = {1, 2, 1, 0, 0, 1, 2, 5, 10, 20};

    // Sorted Input Data
    private static final int[] sortedInsertionSortTimes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] sortedCombSortTimes = {0, 0, 0, 0, 0, 0, 0, 1, 3, 6};
    private static final int[] sortedShakerSortTimes = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] sortedShellSortTimes = {0, 0, 0, 0, 0, 0, 0, 1, 2, 5};
    private static final int[] sortedRadixSortTimes = {0, 0, 0, 0, 0, 1, 2, 4, 10, 19};

    // Reversely Sorted Input Data
    private static final int[] reverseInsertionSortTimes = {0, 0, 3, 12, 48, 194, 776, 3102, 13153, 49231};
    private static final int[] reverseCombSortTimes = {0, 0, 0, 0, 0, 0, 1, 1, 4, 7};
    private static final int[] reverseShakerSortTimes = {0, 0, 3, 13, 53, 220, 870, 3477, 14446, 54064};
    private static final int[] reverseShellSortTimes = {0, 0, 0, 0, 0, 0, 0, 2, 4, 8};
    private static final int[] reverseRadixSortTimes = {0, 0, 0, 0, 0, 1, 2, 5, 10, 19};

    public static void main(String[] args) throws IOException {
        plotGraph("Random Input Data Timing Results", insertionSortTimes, combSortTimes, shakerSortTimes, shellSortTimes, radixSortTimes, "RandomInputResults.png");
        plotGraph("Sorted Input Data Timing Results", sortedInsertionSortTimes, sortedCombSortTimes, sortedShakerSortTimes, sortedShellSortTimes, sortedRadixSortTimes, "SortedInputResults.png");
        plotGraph("Reversely Sorted Input Data Timing Results", reverseInsertionSortTimes, reverseCombSortTimes, reverseShakerSortTimes, reverseShellSortTimes, reverseRadixSortTimes, "ReverseInputResults.png");
    }

    public static void plotGraph(String title, int[] insertionSort, int[] combSort, int[] shakerSort, int[] shellSort, int[] radixSort, String fileName) throws IOException {
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title).xAxisTitle("Input Size (n)").yAxisTitle("Time (ms)").build();

        chart.addSeries("Insertion Sort", dataSizes, insertionSort).setMarker(new None());
        chart.addSeries("Comb Sort", dataSizes, combSort).setMarker(new None());
        chart.addSeries("Shaker Sort", dataSizes, shakerSort).setMarker(new None());
        chart.addSeries("Shell Sort", dataSizes, shellSort).setMarker(new None());
        chart.addSeries("Radix Sort", dataSizes, radixSort).setMarker(new None());

        BitmapEncoder.saveBitmap(chart, fileName, BitmapEncoder.BitmapFormat.PNG);
    }
}
