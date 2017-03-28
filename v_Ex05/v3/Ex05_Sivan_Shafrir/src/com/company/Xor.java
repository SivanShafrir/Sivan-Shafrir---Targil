package com.company;

import java.io.*;

/**
 * Created by Siven on 20/03/2017.
 */
public class Xor extends AlgorithmOperation {
    Input input;
    Output output;
    RandomKey key;

    public Xor(Input input, Output output,  Key key) {
        this.input = input;
        this.output = output;
        this.key = (RandomKey) key;
    }

    @Override
    public int operationEncryption(int oneByte) {
        return oneByte^key.getKey();
    }

    @Override
    public int operationDecryption(int oneByte) {
        return oneByte^key.getKey();
    }

    @Override
    Key getkey() {
        return key;
    }
}


