package com.company;

import java.io.File;

/**
 * Created by Siven on 03/03/2017.
 */
public interface Operations {
    void decryptFile(File sourceFile,int key);
    void encryptFile(File sourceFile,int key);
}
