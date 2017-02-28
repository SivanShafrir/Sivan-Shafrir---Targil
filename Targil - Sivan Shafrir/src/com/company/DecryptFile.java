package com.company;

import java.io.File;
import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/28/2017.
 */
public class DecryptFile extends FileOperations {
    public DecryptFile() {
    }

    public static void decrypt(){
        if(checkpath())
            System.out.println("Decrypt");
        else
            throw new InvalidParameterException("Wrong path  16-DecryptFile : Decrypt");
    }
}
