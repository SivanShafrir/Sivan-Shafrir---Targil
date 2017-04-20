package com.company;

import java.io.File;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double<T,S> extends AlgorithmOperation<DoubleKey<T,S>> {
    AlgorithmOperation algorithm1;
    AlgorithmOperation algorithm2;

    public Double(AlgorithmOperation a1, AlgorithmOperation a2) {
        algorithm1=a1;
        algorithm2=a2;
    }

    @Override
    int decryption(int oneByte) {
        return algorithm1.decryption(algorithm2.decryption(oneByte));
    }

    @Override
    int encryption(int oneByte) {
        return algorithm2.encryption(algorithm1.encryption(oneByte));
    }

}
