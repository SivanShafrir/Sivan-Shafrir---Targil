package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/21/2017.
 */
public  class AlgorithmOperation {//implements Operations
   /* public static final int decryption = 2;
    public static final int encryption = 1;*/
   File destinationFile;
    public static Listener listener;

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }

    public void startedEncryption (){
        if(listener != null)
            listener.startEncrypt();
    }

    public void finishedEncryption(){
        if(listener != null)
            listener.finishEncrypt();
    }
    public void startedDecryption(){
        if(listener != null)
            listener.startDecrypt();
    }
    public void finishedDecryption(){
        if(listener != null)
            listener.finishDecrypt();
    }

    public String makeFile(File sourceFile, int type) {
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
    }

   /* void operationByKey(File file, int type, int key){
       // started();
        String newName = " ";
        if (type==decryption )
            newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.txt";
        else
            newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".encrypted.txt";
        File newFile = new File(newName);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            //encryption
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(newFile);
            while ((oneByte = inputStream.read())!=-1) {
                if (type==decryption)
                    oneByte = operationDecryption(oneByte,key);
                else
                    oneByte = operationEncryption(oneByte,key);
                outputStream.write(oneByte);
            }
          //  ended();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if( outputStream!=null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }*/

   /* @Override
    public void decryptFile(File sourceFile, int key) {
        operationByKey(sourceFile, decryption,key);
    }

    @Override
    public void encryptFile(File sourceFile, int key) {
        operationByKey(sourceFile, encryption,key);
    }

    public int operationEncryption(int oneByte,int key) {
        return oneByte;
    }

    public int operationDecryption(int oneByte,int key) {
        return oneByte;
    }*/


    interface Listener {
        void startEncrypt();
        void finishEncrypt();
        void startDecrypt();
        void finishDecrypt();
    }
}
