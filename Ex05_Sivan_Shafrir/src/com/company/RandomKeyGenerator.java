package com.company;

import java.util.Random;

/**
 * Created by Siven on 20/03/2017.
 */
public class RandomKeyGenerator implements KeyGenerator<Integer> {
    protected Random random;
    protected Integer key;

    public RandomKeyGenerator() {
        this.random =new Random(System.nanoTime());
    }

    @Override
    public Key<Integer> createKey() {
        return new Key<>(random.nextInt(256));
        //return new Key<>(1);
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
