package com.company;

import java.util.Random;

/**
 * Created by hackeru on 3/22/2017.
 */
public class RandomKey implements Key {
    private Random random;

    public RandomKey() {
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public int getKey() {
        int key = random.nextInt(255);
        return key;
    }
}
