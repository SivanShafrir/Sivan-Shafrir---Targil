package com.company;

import java.io.File;
import java.io.*;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Multiplication extends AlgorithmOperation implements  Operations{
    Input input;
    Output output;
  //  File destinationFile;

    public Multiplication(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public int operationEncryption(int oneByte, int key) {
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public int operationDecryption(int oneByte, int key) {
        key = changeKey(key);
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public void decryptFile(File file, File returnFile, int key) {
        if(key%2 == 0)
            super.decryptFile(file, returnFile, key+1);
        else super.decryptFile(file, returnFile,key);
    }

    @Override
    public void encryptFile(File file, File returnFile, int key) {
        if(key%2 == 0)
            super.encryptFile(file, returnFile,key+1);
        else super.encryptFile(file, returnFile, key);

    }


    private int changeKey(int key){
        int decKey = 0;
        for (int i = 0; i < 256; i++) {
            if(((i * key)& 0x000000FF) == 1) {
                decKey = i;
                break;
            }
        }
        return decKey;
    }


}

