/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

/**
 *
 * @author 345983704
 */
public class Searching {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[5];
        int[] b = new int[50];
        int[] c = new int[500];
        int[] d = new int[5000];
        int[][] ar = {a, b, c , d};
        String[] algs = {"insert", "select", "bubble"};
        populate(ar);
        double total = 0;
        long t = System.nanoTime();
        System.out.println(binSearch(d, 5000));
        System.out.println("It took " + ((System.nanoTime() - t) * (Math.pow(10, -6))) + " milliseconds");
    }
    
    public static void populate(int[][] arrays) {
        for (int[] i : arrays) {
            for (int j=0; j<i.length; j++) {
                i[j] = j+1;
            }
        }
    }
    
    public static int binSearch(int[] array, int val) {
        int min = 0;
        int max = array.length;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (array[mid] == val) {
                return mid;
            }
            if (array[mid] > val) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }
    
    public static int binSearchRec(int[] array, int min, int max, int val) {
        if (min == max) {
            return - 1;
        }
        int mid = (max + min) / 2;
        if (array[mid] == val) {
            return mid;
        }
        if (array[mid] > val) {
            return binSearchRec(array, min, mid - 1, val);
        }
        return binSearchRec(array, mid + 1, max, val);
    }
    
}
