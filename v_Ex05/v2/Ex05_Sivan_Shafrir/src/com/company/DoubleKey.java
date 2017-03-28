package com.company;

import java.io.Serializable;

/**
 * Created by hackeru on 3/26/2017.
 */
public class DoubleKey <T,S>implements Key {

    T firstKey;
    S secondKey;


    public void setFirstKey(T firstKey) {
        this.firstKey = firstKey;
    }

    public void setSecondKey(S secondKey) {
        this.secondKey = secondKey;
    }

    @Override
    public T getKey() {
        return firstKey;
    }

    public S getSecondKey() {
        return secondKey;
    }
}
