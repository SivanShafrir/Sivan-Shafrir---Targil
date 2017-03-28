package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public class AlgorithmOperation implements Operations{//
    public static final int decryption = 2;
    public static final int encryption = 1;
   File destinationFile;
    public static Listener listener;

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }


  /*  public String makeFile(File sourceFile, int type) {
        String fileName = sourceFile.getAbsolutePath();
        int pos = fileName.lastIndexOf(".");
        if (pos > 0) {
            fileName = fileName.substring(0, pos);
        }
        if (type == 1) {
            destinationFile = new File(new String(fileName + "_decrypted.txt"));
        } else {
            destinationFile = new File(new String(fileName + "_encrypted.txt"));
        }
        return destinationFile.getAbsolutePath();
    }*/
    public static String fileExtension(File file, int type)
    {
        String prefix = file.getPath().substring(0, file.getPath().lastIndexOf('.'));
        String fullPath;
        if (type == encryption) {
            fullPath = prefix + ".encrypted.txt";
        }
        else
            fullPath  = prefix + ".decrypted.txt";

        return fullPath;
    }

    void operationByKey(File file, File newFile, int type, int key) {
        started();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(newFile);
            while ((oneByte = inputStream.read()) != -1)
            {
                if (type == decryption)
                    oneByte = operationDecryption(oneByte, key);
                else
                    oneByte = operationEncryption(oneByte, key);
                outputStream.write(oneByte);
            }
            ended();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public int operationEncryption(int oneByte, int key) {
        return oneByte;
    }

    public int operationDecryption(int oneByte, int key) {
        return oneByte;
    }

    @Override
    public void decryptFile(File file, File returnFile, int key) {
        operationByKey(file, returnFile, decryption, key);
    }

    @Override
    public void encryptFile(File file, File returnFile, int key) {
        operationByKey(file, returnFile, encryption, key);
    }
    void started() {
        if (listener != null)
            listener.StartDetect();
    }

    void ended() {
        if (listener != null)
            listener.EndDetect();
    }

    interface Listener {
        void StartDetect();
        void EndDetect();

    }
}
