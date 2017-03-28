package com.company;

import java.io.File;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double extends AlgorithmOperation {
    AlgorithmOperation firstAlgorithm;
    AlgorithmOperation secondAlgorithm;
    DoubleKey<Integer,Integer> keyDouble;


    public Double(AlgorithmOperation firstAlgorithm, AlgorithmOperation secondAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm = secondAlgorithm;
        keyDouble = new DoubleKey<>(firstAlgorithm.getkey(), secondAlgorithm.getkey());
    }

    public void setKeyDouble(DoubleKey<Integer, Integer> key) {
        this.keyDouble.firstKey = key.secondKey;
        this.keyDouble.secondKey = key.firstKey;

    }

    @Override
    public void decryptFile(File file, File returnFile) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.temp.txt";
        File temp = new File(newName); //todo: move to class FileHandler
       secondAlgorithm.decryptFile(file,temp);
       firstAlgorithm.decryptFile(temp,returnFile);
       temp.delete();
    }

    @Override
    public void encryptFile(File file, File returnFile) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.temp.txt";
        File temp = new File(newName);
        firstAlgorithm.encryptFile(file,temp);
        secondAlgorithm.encryptFile(temp,returnFile);
        temp.delete();
    }
}
