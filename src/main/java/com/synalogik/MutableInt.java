package com.synalogik;

/**
 * Stores a value of an int that has methods for incrementing and fetching
 */
public class MutableInt {
    int value = 1;
    public void increment () { ++value;      }
    public int  get ()       { return value; }
}
