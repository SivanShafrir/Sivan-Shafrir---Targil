package com.company;

import java.io.File;

/**
 * Created by Siven on 03/03/2017.
 */
public interface Operations {
    String decryptFile(File sourceFile,int key);
    String encryptFile(File sourceFile,int key);
}
