package org.javapp;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;


public class App {

    public static void main(String[] args) {
//        String s="vdvk";
//        Set<Character> set = new HashSet<>();
//        int left = 0, max = 0;
//
//        for (int right = 0; right < s.length(); right++) {
//            while (set.contains(s.charAt(right))) {
//                set.remove(s.charAt(left++));
//            }
//
//            set.add(s.charAt(right));
//            max = Math.max(max, right - left + 1);
//        }
//        System.out.println(max + " " + set);

//        int[] a = {2, 4, 7, 8, 10, 12};
//        int t = 8, index = -1, s = 0, e = a.length-1;
//        int m;
//        for (int i = 0; i < a.length; i++) {
//            m = s + (e - s) / 2;
//            if (a[m] == t) {
//                index = m;
//                System.out.println(index);
//                return;
//            } else if (a[m] > t) {
//                e = m - 1;
//            } else {
//                s = m + 1;
//            }
//        }



//        int[] a = {2, 4, 7, 8, 8, 8, 8,8, 12};
//        int t = 8, index = -1, s = 0, e = a.length-1;
//        int m;
//        while (s<=e) {
//            m = s + (e - s) / 2;
//            if (a[m] == t) {
//                index = m;
//                s=m+1;
//            } else if (a[m] > t) {
//                e = m - 1;
//            } else {
//                s = m + 1;
//            }
//        }
//        System.out.println(index);


        int[] a = {4,5,6,7,0,1,2};
        int index = -1, s = 0, e = a.length-1;
        int m, t=0;
        int n=a.length;
        while (s<=e) {
            m = (s + (e - s) / 2);
            if (a[m] ==t) {
                index = m;
                break;
            } else if (a[m]>a[n-1]) {

            }
//            else if () {
//                e =( m - 1 +n)%n;
//            }
        }
        out.println(index);


    }

    static int searchItem(int[] a, int s, int e, int t){
        if (s>e)
            return  -1;
        int m = s + (e - s) / 2;

        if (a[m] == t) {
            return m;
        } else if (a[m] > t) {
            return searchItem(a, s, m-1, t);
        } else {
            return searchItem(a, m+1, e, t);
        }
    }
}
