package com.company;

import java.io.Serializable;

/**
 * Created by Siven on 20/03/2017.
 */
public class Key<K> implements Serializable{
    private K keyValue;

    public Key(K key) {
        this.keyValue = key;
    }

    public K getKeyValue() {
        return keyValue;
    }
}
