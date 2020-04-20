public class FindStringPattern {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0};
        //all strings using first 1, first val is always one
        //possibilities: 1, 11, 111,1111....1 , 101, 11011, 1110111, 11...0...11
        //expected count is 3  for 11011 - 1, 11, 11011
        //expected count is 3  for 11101 - 1, 11, 111
        //expected count is 2  for 10111 - 1, 101

        int count = 0;
        int position = 0;
        for (int val : arr) {
            if (val == 1) count++;
            else break;
            position++;
        }
        if (position < arr.length) {
            int i = 0;
            for (i = 1; i <= position && i< arr.length - position; i++) {
                if (arr[position + i] != 1) break;
            }
            if (i > position) count++;
        }
        System.out.println(count);


    }
}
