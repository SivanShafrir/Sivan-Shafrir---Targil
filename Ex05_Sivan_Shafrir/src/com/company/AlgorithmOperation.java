package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public abstract class AlgorithmOperation<T>{//

    Key<T> key;

    public void setKey(Key<T> key) {
        this.key = key;
    }

    public T getKey() {
        return key.getKeyValue();
    }



    public byte[] encryptOrDecryptAlgorithm( byte[] fileData , boolean choiceEncrypt){
        int i=0;
        byte[] bytes=new byte[fileData.length];
        while (i < fileData.length){
            if(choiceEncrypt)
                bytes[i]= (byte)encryption(fileData[i]);
            else
                bytes[i]= (byte)decryption(fileData[i]);
            i++;
        }
        return bytes;
    }

    abstract int decryption(int oneByte);
    abstract int encryption(int oneByte);


   /* public static String fileExtension(File file, int type)
    {
        String prefix = file.getPath().substring(0, file.getPath().lastIndexOf('.'));
        String fullPath;
        if (type == encryption) {
            fullPath = prefix + ".encrypted.txt";
        }
        else
            fullPath  = prefix + ".decrypted.txt";

        return fullPath;
    }*/


}
