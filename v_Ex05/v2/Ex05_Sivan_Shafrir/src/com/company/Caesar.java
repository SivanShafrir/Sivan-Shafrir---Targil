package com.company;

import java.io.*;

/**
 * Created by Siven on 20/03/2017.
 */
public class Caesar extends AlgorithmOperation {

    Input input;
    Output output;


    public Caesar(Input input, Output output) {
        this.input = input;
        this.output = output;
    }


    @Override
    public int operationEncryption(int oneByte, int key) {
        return oneByte + key;
    }

    @Override
    public int operationDecryption(int oneByte, int key) {
        return oneByte - key;
    }
}


