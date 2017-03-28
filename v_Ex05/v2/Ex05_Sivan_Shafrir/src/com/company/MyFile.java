package com.company;

import java.io.*;

/**
 * Created by This_user on 23/03/2017.
 */
public class MyFile extends File {


    public MyFile(String pathname) {
        super(pathname);

    }

    public void writeObjectToFile (File file, Serializable toWrite){
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file,true);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(toWrite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            handleEndOfTraffic(objectOutputStream, outputStream);
        }
    }

    private void handleEndOfTraffic(ObjectOutputStream objectOutputStream, OutputStream outputStream) {
        if(objectOutputStream != null)
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Serializable readObjectFromFile (File file){
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        Serializable toRead = null;
        try{
            inputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(inputStream);
            toRead = (Serializable) objectInputStream.readObject();
            //return toRead;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(objectInputStream != null)
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        return toRead;
    }

    public void closeFile(){

    }
}
