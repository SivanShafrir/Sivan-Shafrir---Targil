package com.company;

import java.io.File;

/**
 * Created by Siven on 20/03/2017.
 */
public class Reverse extends AlgorithmOperation  {
    Input input;
    Output output;
    Operations operationsAlgorithmToUse;


    public Reverse(Input input, Output output, Operations operationsAlgorithmToUse) {
        this.input = input;
        this.output = output;
        this.operationsAlgorithmToUse = operationsAlgorithmToUse;
    }

    @Override
    public void decryptFile(File file, File returnFile, int key) {
        super.encryptFile(file, returnFile, key);
    }

    @Override
    public void encryptFile(File file, File returnFile, int key) {
        super.decryptFile(file, returnFile, key);
    }
}
