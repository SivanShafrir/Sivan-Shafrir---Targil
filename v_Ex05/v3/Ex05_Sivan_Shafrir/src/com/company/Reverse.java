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
    public void decryptFile(File file, File returnFile) {
        super.encryptFile(file, returnFile);
    }
//, int key, key
    @Override
    public void encryptFile(File file, File returnFile) {
        super.decryptFile(file, returnFile);
    }
    //, int key, key
}
