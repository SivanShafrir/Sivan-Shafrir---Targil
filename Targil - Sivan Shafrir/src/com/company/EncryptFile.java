package com.company;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/28/2017.
 */
public class EncryptFile extends FileOperations{
    public EncryptFile() {
    }

    public static void encrypt(){
        if(checkpath())
            System.out.println("encrypt");
        else
            throw new InvalidParameterException("Wrong path  16-EncryptFile : encrypt");

    }
}
