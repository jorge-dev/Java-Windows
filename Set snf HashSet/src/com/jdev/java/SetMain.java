package com.jdev.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {

        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100 ; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes") ;

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains "+ union.size() + " elements");

        Set<Integer> inter = new HashSet<>(squares);
        inter.retainAll(cubes);
        System.out.println("Intersection contains "+ union.size() + " elements");

        for (int i: inter){
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));



        }
        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] aWords = sentence.split(" ");
        words.addAll(Arrays.asList(aWords));

        for (String s: words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWord = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWord));
        String[] divineWord = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWord));

        System.out.println("nature-divine:");
        Set<String > diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine-nature:");
        Set<String > diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);


        Set<String> unionT = new HashSet<>(nature);
        unionT.addAll(divine);
        Set<String> inters = new HashSet<>(nature);
        inters.retainAll(divine);

        System.out.println("Symmetric diff is: ");

        unionT.removeAll(inters);
        printSet(unionT);


        if (nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(inters)){
            System.out.println("intersection is a subset of nature");
        }

        if (divine.containsAll(inters)){
            System.out.println("inters is a subset of divine");
        }









    }
    private static void printSet(Set<String> word){
        System.out.print("\t");
        for (String s: word){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
