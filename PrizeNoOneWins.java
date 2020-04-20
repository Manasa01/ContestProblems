import java.util.*;

public class PrizeNoOneWins {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int X = s.nextInt();
        ArrayList<Integer> pq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pq.add(s.nextInt());
        }
        Collections.sort(pq);
        int sum = 0;
        int previous = 0;
        int current = 0;
        //int result = 0;
        int i;
        for (i = 1; i < n; i++) {
            if (pq.get(i) + pq.get(i - 1) > X) {
                break;
            }
            previous = current;
            //   result++;
        }
        // if (n == 1) result = 1;
        System.out.println(i);

    }

}
