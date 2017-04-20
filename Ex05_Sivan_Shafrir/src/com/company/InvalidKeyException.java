package com.company;

/**
 * Created by Rubin on 25/03/2017.
 */
public class InvalidKeyException extends Exception {
    InvalidKeyException(String errorMsg){
        super("invalid key " + errorMsg);
    }
}
