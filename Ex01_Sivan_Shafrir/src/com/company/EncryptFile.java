package com.company;

import java.io.File;
import java.nio.file.OpenOption;
import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/28/2017.
 */
public class EncryptFile implements Operations{
    public EncryptFile() {
    }

    @Override
    public void crypt(File file) {
        System.out.println("encrypt");
    }

   /* public static void encrypt(){
        if(checkpath())
            System.out.println("encrypt");
        else
            throw new InvalidParameterException("Wrong path  16-EncryptFile : encrypt");

    }*/
}
