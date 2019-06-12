package com.jdev.java;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

    Array<Integer> ran = new Array<>(0);
    HeapSort<Integer> util = new HeapSort<>();
    Integer [] ar1 = {};
    //Random r = new Random();
    for (int i = 0; i < ran.length(); i++) {
        ran.set(i,ar1[i]);
    }

        for (int i = 0; i < ran.length(); i++) {
            System.out.println(ran.get(i));
        }

        util.sort(ran);

        for (int i = 0; i < ran.length(); i++) {
            System.out.println(ran.get(i));
        }



    }
}
