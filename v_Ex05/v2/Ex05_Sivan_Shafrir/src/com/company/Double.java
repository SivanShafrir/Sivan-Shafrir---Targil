package com.company;

import java.io.File;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double extends AlgorithmOperation {
    AlgorithmOperation firstAlgorithm;
    AlgorithmOperation secondAlgorithm;
    DoubleKey key2;

    public Double(AlgorithmOperation firstAlgorithm, AlgorithmOperation secondAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm = secondAlgorithm;
    }

    public void setKey(DoubleKey key) {
        this.key2 = key;
    }

    private void reverseDouble(DoubleKey key) {
        if (key2 == null)
            key2 = key;
    }

    @Override
    public void decryptFile(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key2);
        secondAlgorithm.decryptFile(file, temp, (Integer) key2.getKey());
        firstAlgorithm.decryptFile(temp, returnFile, (Integer) key2.getSecondKey());
        temp.delete();
    }

    @Override
    public void encryptFile(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key2);
        firstAlgorithm.encryptFile(file, temp, (Integer) key2.getKey());
        secondAlgorithm.encryptFile(temp, returnFile, (Integer) key2.getSecondKey());
        temp.delete();
    }
}
