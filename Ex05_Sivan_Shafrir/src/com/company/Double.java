package com.company;

import java.io.File;
import java.util.function.ToDoubleBiFunction;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Double <T extends Operations,K extends Operations> implements Operations {
    T firstAlgorithm;
    K secondAlgorithm;

    public Double(T firstAlgorithm, K secondAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm = secondAlgorithm;
    }

    @Override
    public void decryptFile(File sourceFile, int key) {
        secondAlgorithm.decryptFile(sourceFile,key);
        firstAlgorithm.decryptFile( new File(new AlgorithmOperation().makeFile(sourceFile,1)),1);
        //TODO: delete unneccssary file
    }

    @Override
    public void encryptFile(File sourceFile, int key) {
        firstAlgorithm.encryptFile(sourceFile,key);
        secondAlgorithm.encryptFile(new File(new AlgorithmOperation().makeFile(sourceFile,2)),2);
        //למחוק את הקובץ שיצא מפירסט אלגוריתם - לא צריך אותו
        //TODO: delete unneccssary file

    }
}
