package com.jdev.java;

import java.util.NoSuchElementException;

public class HeapSort<T extends Comparable<T>> {


// methods described in Lecture 17

    /*=========================================================
      Method:        isRoot
      Description:   returns a boolean value to indicate whether
                     the given input x is the root of the heap.
                     x >= 0 is assumed
      ===========================================================*/
    private boolean isRoot(int x){

        return(x == 0);

    }

    /*=========================================================
      Method:        parent
      Description:   returns the index of the parent of x if this
                     has one.
                     1 <= x <= Array.LENGTH is assumed
      ===========================================================*/
    private int parent(int x){
        int result;
        boolean even;

        //since x can be even or odd, this has to be handled in two
        //cases
        even = ( (x % 2) == 0);
        if (even) {
            result = (x - 2)/2;
        }
        else{
            result = (x - 1)/2;
        }
        return result;
    }

    /*=========================================================
      Method:        value
      Description:   returns the value stores at index x
      1 <= x <= Array.LENGTH is assumed
      ===========================================================*/
    private T value(Array<T> A, int x){

        return A.get(x);

    }

    /*=========================================================
      Method:        bubbleUp
      Description:   method needed for insert implementation.
                     Swaps the value in index x with its parent
                     if x's value is greater than its parent's.
                     Recursion stops when the root of heap is reached
                     or x's value is less than its parent's.
      ===========================================================*/
    private void bubbleUp(Array<T> A, int x){
        System.out.println(" You are in bubbleUp ");

        T value_of_x = value(A, x);
        T value_of_x_parent = value(A,parent(x));
        //compares x's value with its parent
        int xValueComp = value_of_x.compareTo(value_of_x_parent);

        if(!isRoot(x) && (xValueComp > 0)){
            T temp = value_of_x;
            A.set(x, value_of_x_parent);
            A.set(parent(x), temp);
            bubbleUp(A, parent(x));


        }

    }

    /*=========================================================
      Method:        insert
      Description:
      ===========================================================*/
    private void insert(Array<T> A, T x){

        System.out.println(" You are in insert ");

        int heapSize = 1;
        if (heapSize < A.length()){

            A.set(heapSize,x);
            heapSize += 1;
            bubbleUp(A,heapSize);
        }
        else {
            System.out.println(" Heap is Full ");
        }
    }

    /*=========================================================
      Method:        hasLeft
      Description:
      ===========================================================*/
    private boolean hasLeft(Array<T> A, int x){
        int heapSize = A.length();
        return ((2*x + 1) < heapSize);
    }



    /*=========================================================
      Method:        hasRight
      Description:
      ===========================================================*/
    private boolean hasRight(Array<T> A, int x){
        int heapSize = A.length();
        return ((2*x + 2) < heapSize);
    }


    /*=========================================================
      Method:        left
      Description:
      ===========================================================*/
    private int left( int x){

        return (2*x + 1);
    }


    /*=========================================================
      Method:        right
      Description:
      ===========================================================*/
    private int right( int x){

        return (2*x + 2);
    }

    /*=========================================================
      Method:        bubbleDown
      Description:
      ===========================================================*/
    private void bubbleDown(Array<T> A, int x){
        int compare_left_right = value(A,left(x)).compareTo(value(A,right(x)));
        int compare_left_x = value(A,left(x)).compareTo(value(A,x));
        int compare_right_x = value(A,right(x)).compareTo(value(A,x));
        //int value_left = value(A,left(x));
        //int value_right = value(A,right(x));
        if (hasRight(A,x)){
            if (compare_left_right >= 0){ //
                if(compare_left_x > 0){ //
                    T temp = value(A,left(x));
                    A.set(left(x),value(A,x));
                    A.set(x, temp);
                    bubbleDown(A,left(x));
                }// end last if

            }// end sec-last if

            else if(compare_right_x > 0){

                T temp = value(A,right(x));
                A.set(right(x), value(A,x));
                A.set(x, temp);
                bubbleDown(A,right(x));

            }// end else if inside main if


        }// end main if

        else if(hasLeft(A,x)){
            if (compare_left_x > 0){
                T temp = value(A,left(x));
                A.set(left(x),value(A,x));
                A.set(x, temp);
                bubbleDown(A,left(x));

            }// end if inside else if



        }// end last end if

    }//end method





    /*=========================================================
      Method:        deleteMax
      Description:
      ===========================================================*/
    private T deleteMax (Array<T> A) throws NoSuchElementException {
        System.out.println( " You are in delete ");
        int heap_size = A.length();
        if (heap_size == 0){
            throw new NoSuchElementException("heap is empty.");
        }

        else {
            T v = A.get(heap_size -1);
            heap_size -= 1;
            if (heap_size == 0){
                return v;
            }

            else {
                T delete = A.get(0);
                A.set(0,v);
                bubbleDown(A,0);
                return delete;
            }

        }



    }






/*=========================================================
  Method:        sort
  Description:
  ===========================================================*/

    public void sort( Array<T> A ){

        Array<T> H = new Array<T>(1);
        int i = 1;
        while (i < A.length()){

            insert(A,H.get(i));
            System.out.println(H.get(i));
            i+= 1;
        }
        i = A.length() - 1;
        while (i > 0){

            T largest = deleteMax(H);
            A.set(i,largest);
            System.out.println(A.get(i));
            i -=1;

        }




    }






}
