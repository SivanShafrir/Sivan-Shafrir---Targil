package com.company;

import java.io.Serializable;

/**
 * Created by Siven on 20/03/2017.
 */
public class DoubleKey<T,S> implements Serializable {

    T key1;
    S key2;

    public DoubleKey(T key1, S key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public T getKey1() {
        return key1;
    }

    public void setKey1(T key1) {
        this.key1 = key1;
    }

    public S getKey2() {
        return key2;
    }

    public void setKey2(S key2) {
        this.key2 = key2;
    }
}
