package com.company;

import com.company.Key;

import java.io.Serializable;

public class DoubleKey <T,S> implements Serializable {

    Key<T> firstKey;
    Key<S> secondKey;

    public Key<S> getSecondKey() {
        return secondKey;
    }

    public DoubleKey(Key<T> firstKey, Key<S> secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public void setSecondKey(Key<S> secondKey) {
        this.secondKey = secondKey;
    }

    public Key<T> getFirstKey() {
        return firstKey;
    }

    public void setFirstKey(Key<T> key) {
        firstKey=key;
    }
}