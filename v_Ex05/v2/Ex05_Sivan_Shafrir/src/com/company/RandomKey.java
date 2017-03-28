package com.company;

import java.util.Random;

/**
 * Created by hackeru on 3/22/2017.
 */
public class RandomKey implements Key<Integer> {
    private Random random;
    Integer key;

    public RandomKey() {
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public Integer getKey() {
         key = random.nextInt(255);
        return key;
    }
}
