package com.company;

import java.io.File;
import java.io.*;

/**
 * Created by hackeru on 3/22/2017.
 */
public class Multiplication extends AlgorithmOperation implements  Operations{
    Input input;
    Output output;
  //  File destinationFile;

    public Multiplication(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

   /* public void makeFile(File sourceFile, int type) {
        String fileName = sourceFile.getAbsolutePath();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        if (type == 1) {
            destinationFile = new File(new String(fileName + "_encrypted.txt"));
        } else {
             destinationFile = new File(new String(fileName + "_decrypted.txt"));
        }
    }*/
    public void crypt(File sourceFile, int key, int type) {
        makeFile(sourceFile, type);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);
            int buffer;
            if (type==1) {
                while ((buffer = inputStream.read()) != -1) {
                    outputStream.write(buffer * key);
                }
            } else {
                int decryptionKey = 0;
                for (int i = 1; i <= 255; i++) {
                    if (((i * key) & 0x000000FF) == 1) {
                        decryptionKey = i;
                        break;
                    }
                }
                while ((buffer = inputStream.read()) != -1) {
                    outputStream.write(buffer * decryptionKey);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    @Override
    public void encryptFile(File sourceFile, int key) {
        startedDecryption();
        makeFile(sourceFile,1);
        crypt(sourceFile,key,1);
        finishedDecryption();

    }

    @Override
    public void decryptFile(File sourceFile, int key) {
        startedEncryption();
        makeFile(sourceFile,2);
        crypt(sourceFile,key,2);
        finishedEncryption();
    }

}
