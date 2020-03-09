import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int a=110000;

//            char[] a;
//            char[] b;
//
//
//            int num=0;
//
//            Scanner scanner=new Scanner(System.in);
//            a=scanner.nextLine().toCharArray();
//            b=scanner.nextLine().toCharArray();
//
//
//            for(char d:a){
//                if(Character.toLowerCase(b[0])==Character.toLowerCase(d)){
//                    num++;
//                }
//
//            };
//            System.out.println(num);

        Scanner scanner = new Scanner(System.in);
        int[] p = new int[1000];
        int de = 0;

            while (scanner.hasNext()) {

                int a = scanner.nextInt();
                int b;
                int length = 0;
                int[] c = new int[1000];
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

                System.arraycopy(c, 0, p, de, a);
                de += a;


            }

            for (int e = 0; 0 != p[e]; e++) {
                System.out.println(p[e]);


            }
        }

}