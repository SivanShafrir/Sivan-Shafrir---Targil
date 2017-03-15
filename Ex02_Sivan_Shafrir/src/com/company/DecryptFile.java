package com.company;

import java.io.File;

/**
 * Created by hackeru on 2/28/2017.
 */
public class DecryptFile implements Operations {
    public DecryptFile() {
    }

    @Override
    public String crypt(File file) {
       // System.out.println("Decrypt");
        return "Decrypt";
    }

    /*public static void decrypt(){
        if(checkpath())
            System.out.println("Decrypt");
        else
            throw new InvalidParameterException("Wrong path  16-DecryptFile : Decrypt");
    }*/
}
