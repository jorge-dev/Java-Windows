package com.jdev.java;

import java.util.NoSuchElementException;

public class HeapSort<T extends Comparable<T>> {

private int heapSize = 0;
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

      //  if (!isRoot(x)) {
            //since x can be even or odd, this has to be handled in two
            //cases
         /*   even = ((x % 2) == 0);
            if (even) {
                result = (x - 2) / 2;
            } else {
                result = (x - 1) / 2;
            }
            return result;*/
       // }
     //   else {
      //      throw  new ArrayIndexOutOfBoundsException("Opps"); }

        if (x%2 == 0) {
            return (x-2)/2;
        } else {
            return (x-1)/2;
        }
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
      /*
        System.out.println(" You are in bubbleUp ");

        T value_of_x = value(A, x);
       // T value_of_x_parent = value(A,parent(x));
        //compares x's value with its parent
        //int xValueComp = value_of_x.compareTo(value_of_x_parent);

        if((!isRoot(x)) && (value_of_x.compareTo(value(A,parent(x))) > 0)){
            T temp = A.get(x);
            A.set(x, A.get(parent(x)));
            A.set(parent(x), temp);
            bubbleUp(A, parent(x));


        }
        */

        while ((x > 0) && ((A.get(x)).compareTo(A.get(parent(x))) > 0)) {

            T z = A.get(x);
            A.set(x, A.get(parent(x)));
            A.set(parent(x), z);
            x = parent(x);

        }
    }

    /*=========================================================
      Method:        insert
      Description:
      ===========================================================*/
    private void insert(Array<T> A, T x){
/*
        System.out.println(" You are in insert ");


        if (heapSize < A.length()){
            int i = heapSize ;
            A.set(i,x);
            heapSize = heapSize + 1;

            bubbleUp(A,i);
        }
        else {
            System.out.println(" Heap is Full ");
        }

*/

        if (heapSize < A.length()) {

            A.set(heapSize, x);
            heapSize = heapSize + 1;
            int i = heapSize-1;
            bubbleUp(A,i);

        } else {

            throw new NullPointerException("This heap is already full.");

        }

    }



    /*=========================================================
      Method:        hasLeft
      Description:
      ===========================================================*/
    private boolean hasLeft(Array<T> A, int x){
        //int heapSize = A.length();
        return ((2*x + 1) < heapSize);
    }



    /*=========================================================
      Method:        hasRight
      Description:
      ===========================================================*/
    private boolean hasRight(Array<T> A, int x){
        //int heapSize = A.length();
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
       /*
        int compare_left_right = value(A,left(x)).compareTo(value(A,right(x)));
        int compare_left_x = value(A,left(x)).compareTo(value(A,x));
        int compare_right_x = value(A,right(x)).compareTo(value(A,x));
        T value_left = value(A,left(x));
        T value_right = value(A,right(x));

        if (hasRight(A,x)){
            if (compare_left_right >= 0){ //
                if(compare_left_x > 0){ //
                    T temp = value_left;
                    A.set(left(x),value(A,x));
                    A.set(x, temp);
                    bubbleDown(A,left(x));
                }// end last if

            }// end sec-last if

            else if(compare_right_x > 0){

                T temp = value_right;
                A.set(right(x), value(A,x));
                A.set(x, temp);
                bubbleDown(A,right(x));

            }// end else if inside main if


        }// end main if

        else if(hasLeft(A,x)){
            if (compare_left_x > 0){
                T temp = value_left;
                A.set(left(x),value(A,x));
                A.set(x, temp);
                bubbleDown(A,left(x));

            }// end if inside else if



        }// end last end if
*/

        while (hasLeft(A,x)) {

            if (hasRight(A,x)) {

                if ((A.get(right(x))).compareTo(A.get(left(x))) >= 0) {

                    if ((A.get(right(x))).compareTo(A.get(x)) > 0) {

                        T z = A.get(x);
                        A.set(x, A.get(right(x)));
                        A.set(right(x), z);
                        x = right(x);

                    } else {

                        x = heapSize - 1;

                    }

                } else  if ((A.get(left(x))).compareTo(A.get(x)) > 0 ){

                    T z = A.get(x);
                    A.set(x, A.get(left(x)));
                    A.set(left(x), z);
                    x = left(x);

                } else {

                    x = heapSize - 1;

                }

            } else  if ((A.get(left(x))).compareTo(A.get(x)) > 0){

                T z = A.get(x);
                A.set(x, A.get(left(x)));
                A.set(left(x), z);
                x = left(x);

            } else {

                x = heapSize - 1;

            }

        }

    }//end method




    /*=========================================================
      Method:        deleteMax
      Description:
      ===========================================================*/
    private T deleteMax (Array<T> A) throws NoSuchElementException {

/*
        System.out.println( " You are in delete ");
      //  int heap_size = A.length();
        if (heapSize == 0){
            throw new NoSuchElementException("heap is empty.");
        }

        else {
            T v = A.get(heapSize -1);
            heapSize = heapSize - 1;
            if (heapSize == 0){
                return v;
            }

            else {
                T delete = A.get(0);
                A.set(0,v);
                bubbleDown(A,0);
                return delete;
            }
*/


        if (heapSize > 0) {

            T z = A.get(0);
            A.set(0, A.get(heapSize - 1));
            A.set(heapSize - 1, null);        // Not necessary; can be missed without penalty
            heapSize = heapSize - 1;
            bubbleDown(A,0);
            return z;

        } else {

            throw new NoSuchElementException("This heap is already empty.");

        }




    }






/*=========================================================
  Method:        sort
  Description:
  ===========================================================*/

    public void sort( Array<T> A ){

        Array<T> H = new Array<T>(A.length());
        heapSize = 1;
        int i = 1;
        if (A.length() > 0) {
            H.set(0, A.get(0));
        }
        while (i < A.length()){

            insert(H,A.get(i));
            System.out.println("H.get = "  + H.get(i));
            i+= 1;
        }

        i = A.length() - 1;
        while (i >= 0){

            T largest = deleteMax(H);
            A.set(i,largest);
        //    System.out.println("A.get = " +A.get(i));
            i -=1;

        }

/*
        while (heapSize > 1) {

            try {

                T current = deleteMax(H);
                A.set(heapSize, current);

            } catch (NoSuchElementException ex) {
            }

        }
*/


    }






}
