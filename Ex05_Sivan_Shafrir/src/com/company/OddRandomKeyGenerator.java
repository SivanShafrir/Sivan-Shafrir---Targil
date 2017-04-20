package com.company;

/**
 * Created by Rubin on 26/03/2017.
 */
public class OddRandomKeyGenerator extends RandomKeyGenerator {

    public OddRandomKeyGenerator() {
        super();
    }

    @Override
    public Key<Integer> createKey() {
        Integer number=random.nextInt(256);
        //Integer number=1;
        if(number % 2 ==0)
            return new Key<>(number+1);
        return new Key<Integer>(number);
    }
}
