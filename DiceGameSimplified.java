import java.util.Scanner;

public class DiceGameSimplified {
    public static void main(String[] args) {
        Scanner oScan = new Scanner(System.in);

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0; i< 4; i++){
            sum1 += oScan.nextInt();
        }
        for(int i=0; i< 4; i++){
            sum2 += oScan.nextInt();
        }
        if (sum1 > sum2) System.out.println("Gunnar");
        else if (sum1 < sum2) System.out.println("Emma");
        else System.out.println("Tie");
    }
}