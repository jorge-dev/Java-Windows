package com.jdev.java;
import java.util.Collection;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Array<E> {
    // Data Fields:
    private final int LENGTH;
    private ArrayList<E> data;

    /**
     *
     * Constructs an Array with a given length

     */

    public Array(int length) {

        if (length < 0) {

            throw new IllegalArgumentException(String.valueOf(length));

        } else {

            this.LENGTH = length;
            this.data = new ArrayList<E>(length);;

            int i = 0;


            while (i < length) {


                this.data.add(null);
                i = i+1;


            }



        }

    }


    /**
     *
     * Returns the length of this Array.

     */

    public int length() {

        return this.LENGTH;

    }

    /**
     *
     * Returns the value at position index for a give index

     */

    public E get(int index) {

        if ((index < 0) || (index >= this.LENGTH)) {

            throw new ArrayIndexOutOfBoundsException(String.valueOf(index));

        } else {

            return this.data.get(index);

        }

    }

    /**
     *
     * Sets to the value of this Array at the given index to be the given value

     */

    public void set(int index, E e) {

        if ((index < 0) || (index >= this.LENGTH )) {

            throw new ArrayIndexOutOfBoundsException(String.valueOf(index));

        } else {

            data.set(index, e);

        }

    }

    /**
     *
     * Returns a ListIterator for this Array.

     */


}

