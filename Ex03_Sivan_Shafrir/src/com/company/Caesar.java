package com.company;

import java.io.*;

/**
 * Created by Siven on 20/03/2017.
 */
public class Caesar implements Operations {
   /* public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;*/


    Input input;
    Output output;
    File destinationFile;

    public Caesar(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void makeFile(File sourceFile, int type) {
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
    }

    public void crypt(File sourceFile, int key, int type) {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);
            int buffer;
            if (type==1) {
                while ((buffer = inputStream.read()) != -1) {
                    outputStream.write(buffer + key);
                }
            } else {
                while ((buffer = inputStream.read()) != -1) {
                    outputStream.write(buffer - key);
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
    public String decryptFile(File sourceFile, int key) {
        makeFile(sourceFile,1);
        crypt(sourceFile,key,1);
        return "Encrypt";

    }

    @Override
    public String encryptFile(File sourceFile, int key) {
        makeFile(sourceFile,2);
        crypt(sourceFile,key,2);
        return "Encrypt";
    }
}
