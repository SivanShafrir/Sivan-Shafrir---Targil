package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by hackeru on 3/27/2017.
 */
public class HandlerFile extends File {


    private boolean isValid=true;

    public HandlerFile(String path) {
        super(path);
    }

    public boolean checkFile(){
        if(!isFile())
            isValid=false;
        if(!exists())
            isValid=false;
        return isValid;
    }

    public static void writeObjectToFile (File file, Serializable toWrite){
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(toWrite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
    }

    static <T> T readObjectFromFile (File file) throws IOException, ClassNotFoundException {
//        InputStream inputStream = null;
//        ObjectInputStream objectInputStream = null;
        T toRead = null;
        try(InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            toRead = (T) objectInputStream.readObject();
        }
        return toRead;
    }


    public static File createFile(File fileFromUser, boolean choiceEncrypt){
        String path = fileFromUser.getAbsolutePath();
        int pos=path.indexOf('.');
        if (pos > 0)
            path = path.substring(0, pos);
        if(choiceEncrypt)
            return new File(path + ".en.txt");
        return new File(path + "_de.txt");
    }
}

