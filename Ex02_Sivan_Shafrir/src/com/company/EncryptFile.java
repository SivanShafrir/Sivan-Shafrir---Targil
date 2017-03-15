package com.company;

import java.io.File;

/**
 * Created by hackeru on 2/28/2017.
 */
public class EncryptFile implements Operations {
    public EncryptFile() {
    }

    @Override
    public String crypt(File file) {
       // System.out.println("Encrypt");
        return "Encrypt";
    }

   /* public static void encrypt(){
        if(checkpath())
            System.out.println("encrypt");
        else
            throw new InvalidParameterException("Wrong path  16-EncryptFile : encrypt");

    }*/
}
