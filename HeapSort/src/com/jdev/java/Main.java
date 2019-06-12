package com.jdev.java;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

    Array<Integer> ran = new Array<>(10);
    HeapSort<Integer> util = new HeapSort<>();

    Random r = new Random();
    for (int i = 0; i < ran.length(); i++) {
        ran.set(i,r.nextInt(20));
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
