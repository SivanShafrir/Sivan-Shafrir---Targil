package com.company;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/28/2017.
 */
public class DecryptFile implements Operations {
    public DecryptFile() {
    }

    @Override
    public void crypt(File file) {
        System.out.println("Decrypt");
    }

    /*public static void decrypt(){
        if(checkpath())
            System.out.println("Decrypt");
        else
            throw new InvalidParameterException("Wrong path  16-DecryptFile : Decrypt");
    }*/
}
