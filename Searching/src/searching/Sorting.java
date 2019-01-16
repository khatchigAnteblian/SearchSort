/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;
import java.util.Random;

/**
 *
 * @author 345983704
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    
    static final Random rnd = new Random();
    
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = new int[50];
        int[] c = new int[500];
        int[] d = new int[5000];
        int[][] ar = {a, b, c , d};
        String[] algs = {"insert", "select", "bubble"};
        populate(ar);
        double total = 0;
        
        
//        System.out.println("Selection Sort 10");
//        test(a);
//        System.out.println("Selection Sort 1000");
//        test(b);
//        System.out.println("Selection Sort 10000");
//        test(c);
//        System.out.println("Insertion Sort 100000");
//        test(ar[3]);
//        populate(ar);
//        test(ar[3]);
        
        for (int i=0; i<3; i++) {
            System.out.println("Algorithm: " + algs[i] + "\n");
            for (int n=0; n<ar.length; n++) {
                total = 0;
                System.out.println("Array " + n);
                for (int j=0; j<10; j++) {
                     total += test(ar[n], algs[i]);
                    populate(ar);
                }
                System.out.println("Average was " + (total / 10) + " seconds");
                System.out.println("\n\n");
            }
        }
        
    }
    
    public static double test(int[] ar, String alg) {
        long t = System.nanoTime();
        if (alg.equals("insert"))
            insertionSort(ar);
        else if (alg.equals("select"))
            selectionSort(ar);
        else
            bubbleSort(ar);
        long t2 = System.nanoTime();
        double time_taken = ((t2 - t) * 0.000000001);
        //System.out.println("It took approximately " + time_taken + " seconds.");
        return time_taken;
    }
    
    public static void populate(int[][] arrays) {
        for (int[] i : arrays) {
            for (int j=0; j<i.length; j++) {
                i[j] = rnd.nextInt(i.length);
            }
        }
    }
    
    public static int[] bubbleSort(int[] a) {
        for(int i=1; i<a.length; i++) {
            boolean swapped = false;
            for (int j=0; j<a.length - i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return a;
            }
        }
        return a;
    }
    
    public static int[] insertionSort(int[] a) {
        for (int i=1; i<a.length; i++) {
            int current = a[i];
            int j = i-1;
            while(j >= 0 && current < a[j]) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = current;
        }
        return a;
    }
    
    public static int[] selectionSort(int[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i+1; j<a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        return a;
    }
    
}
