package com.company;

import java.io.File;

/**
 * Created by Siven on 20/03/2017.
 */
public class Reverse extends AlgorithmOperation implements Operations {
    Input input;
    Output output;
    Operations operationsAlgorithmToUse;


    public Reverse(Input input, Output output, Operations operationsAlgorithmToUse) {
        this.input = input;
        this.output = output;
        this.operationsAlgorithmToUse = operationsAlgorithmToUse;
    }

   @Override
    public void decryptFile(File sourceFile, int key) {
        //startedDecryption();
        operationsAlgorithmToUse.encryptFile(sourceFile, key);
       // finishedDecryption();
    }



    @Override
    public void encryptFile(File sourceFile, int key) {
       // startedEncryption();
        operationsAlgorithmToUse.decryptFile(sourceFile, key);
      //  finishedEncryption();
    }
}
