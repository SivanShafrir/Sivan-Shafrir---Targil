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
  RandomKey key;
    int decKey;

    public Multiplication(Input input, Output output,Key key) {
        this.input = input;
        this.output = output;
        this.key = (RandomKey) key;
    }

    @Override
    public int operationEncryption(int oneByte) {
        return (key.getKey() * oneByte) & 0x000000FF;
    }//, int key

    @Override
    public int operationDecryption(int oneByte) {//, int key
        key.setKey( changeKey(key.getKey()));
        return (key.getKey() * oneByte) & 0x000000FF;
    }

    @Override
    public void decryptFile(File file, File returnFile) {//, int key
        if(key.getKey()%2 == 0)
            key.setKey(key.getKey()+1);
        super.decryptFile(file, returnFile);//, key+1
        //else super.decryptFile(file, returnFile,key);
    }

    @Override
    public void encryptFile(File file, File returnFile) {//, int key
        if(key.getKey()%2 == 0)
            key.setKey( key.getKey()+1);
            super.encryptFile(file, returnFile);//,key+1
       // else super.encryptFile(file, returnFile, key);

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
    @Override
    Key getkey() {
        return key;
    }

}

