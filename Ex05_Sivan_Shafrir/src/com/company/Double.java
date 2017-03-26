package com.company;

import java.io.File;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double implements Operations {// <T extends Operations,K extends Operations>
    Operations firstAlgorithm;
    Operations secondAlgorithm;
    Integer key2;

    public Double(Operations firstAlgorithm, Operations secondAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm = secondAlgorithm;
    }

    public void setKey(int key) {
        this.key2 = key;
    }

    private void reverseDouble(int key) {
        if (key2 == null)
            key2 = key;
    }

    @Override
    public void decryptFile(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key);
        secondAlgorithm.decryptFile(file, temp, key);
        firstAlgorithm.decryptFile(temp, returnFile, key2);
        temp.delete();
    }

    @Override
    public void encryptFile(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key);
        firstAlgorithm.encryptFile(file, temp, key);
        secondAlgorithm.encryptFile(temp, returnFile, key2);
        temp.delete();
    }
}
