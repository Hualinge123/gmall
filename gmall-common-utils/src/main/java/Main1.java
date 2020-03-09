
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] str) {
        Scanner in = new Scanner(System.in);


        while (in.hasNext()) {
            int n = in.nextInt();
            int[] inputArray = new int[n];
            LinkedList<Integer> list = new LinkedList<Integer>();
            LinkedList<Integer> list2 = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                inputArray[i] = in.nextInt();
            }
            Arrays.sort(inputArray);
            for (int i = 0; i < n; i++) {
                list.add(inputArray[i]);
            }
            for (int i = 0; i < n; i++) {
                if (!list2.contains(list.get(i))) {
                    list2.add(list.get(i));
                }
                System.out.println();
            }
            for (Integer ix : list2) {
                System.out.println(ix);
            }
        }
    }
}


