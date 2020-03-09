import java.util.*;

public class Main2 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext()) {

                int a = scanner.nextInt();
                int b;
                int length = 0;
                int[] c = new int[a];
                c[0] = scanner.nextInt();

                A:
                for (int i = 0; i < a - 1; i++) {

                    b = scanner.nextInt();

                    for (int j = length; j >= 0; j--) {

                        if (c[j] == b) {
                            continue A;
                        }

                    }
                    ;

                    for (int k = length; k >= 0; k--) {

                        if (c[k] > b) {
                            c[k + 1] = c[k];
                            if (k == 0) {
                                c[k] = b;
                                break;
                            }

                        } else {
                            c[k + 1] = b;
                            break;
                        }

                    }
                    ;
                    length++;


                }

                for (int e = 0; e<a; e++) {
                    System.out.println(c[e]);
            }




            }
        }

}