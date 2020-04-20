import java.util.Scanner;

public class AboveAverage {

    public static void main(String[] args) {
        Scanner oScan = new Scanner(System.in);
        int testcases = oScan.nextInt();
        for (int i = 0; i < testcases; i++) {
            int N = oScan.nextInt();
            int count = 0;
            int[] array = new int[N];
            double average = 0;
            for (int j = 0; j < N; j++) {
                array[j] = oScan.nextInt();
                average += array[j];
            }
            average = average/ N;
            //System.out.println(average);
            for (int j = 0; j < N; j++) {
                if (array[j] > average) count++;
            }
            double percent = ((double) count * 100.0) / (double) N;
            System.out.printf("%.3f%% \n", Math.round(percent * 1000.0) / 1000.0);

        }

    }
}
