package com.company;

import java.io.File;

/**
 * Created by Siven on 20/03/2017.
 */
public class Reverse<T> extends AlgorithmOperation<T>  {
    AlgorithmOperation makingAlgorithm;

    public Reverse(AlgorithmOperation decOrEnc) {
        this.makingAlgorithm = decOrEnc;
    }

    @Override
    public int decryption(int oneByte) {
        return makingAlgorithm.encryption(oneByte);
    }

    @Override
    public int encryption(int oneByte) {
        return makingAlgorithm.decryption(oneByte);
    }
}
