package com.company;

import java.io.*;

/**
 * Created by Siven on 20/03/2017.
 */
public class Xor extends AlgorithmOperation<Integer> {
    public Xor( Key<Integer> key) {
        this.key=key;
    }

    @Override
    public int decryption(int oneByte) {
        return oneByte ^ (int)key.getKeyValue();
    }

    @Override
    public int encryption(int oneByte) {
        return decryption(oneByte);
    }
}


