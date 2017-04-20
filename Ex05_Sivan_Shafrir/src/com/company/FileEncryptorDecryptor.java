package com.company;

import com.company.AlgorithmOperation;
import com.company.HandlerFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Siven on 14/04/2017.
 */
public class FileEncryptorDecryptor {
    public void encryptFile(File sourceFile, AlgorithmOperation cipher){
        decryptEncryptFile(sourceFile, cipher, true);
    }

    public void decryptFile(File sourceFile, AlgorithmOperation cipher){
        decryptEncryptFile(sourceFile, cipher, false);
    }


    public void decryptEncryptFile(File sourceFile, AlgorithmOperation cipher, boolean isEncrypt){
        File destFile= HandlerFile.createFile(sourceFile,isEncrypt);
        byte[] fileDataEncryptor;
        try {
            byte[] fileData = Files.readAllBytes(Paths.get(sourceFile.getPath()));
            fileDataEncryptor=cipher.encryptOrDecryptAlgorithm(fileData,isEncrypt);
            Files.write(Paths.get(destFile.getPath()), fileDataEncryptor);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
