package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public class AlgorithmOperation implements Operations{//
    public static final int decryption = 2;
    public static final int encryption = 1;
    public static Listener listener;

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }

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

    void operationByKey(File file, File newFile, int type) {//, int key
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
                    oneByte = operationDecryption(oneByte);//, key
                else
                    oneByte = operationEncryption(oneByte);//, key
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

    public int operationEncryption(int oneByte) {
        return oneByte;
    }//, int key

    Key getkey(){return null;};



    public int operationDecryption(int oneByte) {
        return oneByte;
    }//, int key

    @Override
    public void decryptFile(File file, File returnFile) {
        operationByKey(file, returnFile, decryption);
    }

    @Override
    public void encryptFile(File file, File returnFile) {
        operationByKey(file, returnFile, encryption);
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
