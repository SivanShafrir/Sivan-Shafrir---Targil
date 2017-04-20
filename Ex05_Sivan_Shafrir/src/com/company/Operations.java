package com.company;

import java.io.File;

/**
 * Created by Siven on 03/03/2017.
 */
public interface Operations<T> {
    void decryptFile(byte[] input,int type,T key);//,int key
    void encryptFile(byte[] input,int type,T key);//,int key
}
