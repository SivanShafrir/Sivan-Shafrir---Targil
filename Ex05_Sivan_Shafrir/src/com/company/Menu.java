package com.company;

//import com.sun.java.util.jar.pack.Package;

import java.io.File;
import java.util.Random;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Menu implements AlgorithmOperation.Listener {

    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";
    public static final String EXIT = "0";
    Output myOutput;
    Input myInput;
    MyFile myFile;
    FileOperations myFileOperations = new FileOperations();
    Operations operations;
    String filePathString;
    File file;
    String inputChoose;
    Double doubleAlgorithm;
    DoubleKey doubleKey;


    public Menu(Output myOutput, Input myInput) {
        this.myOutput = myOutput;
        this.myInput = myInput;
    }

    public void printMenu() {
        myOutput.output("please choose:\n 1. If you want to encrypt the file Press 1\n 2. If you want to decrypt the file Press 2\n 0. exit\n your choice:\n");
        myChoice();
    }


    public void myChoice() {
        String input;
        input = myInput.input();
        if (input.length() != 0) {
            switch (input) {
                case ENCRYPTION:
                    encryption();
                    break;
                case DECRYPTION:
                    decryption();
                    break;
                case EXIT:
                    myOutput.output("bye bye ");
                    return;
                default: {
                    myOutput.output("invalid option. try again.");
                    printMenu();
                }
            }
        } else {
            myOutput.output("Something went wrong. Please try again");
            return;
        }
        printMenu();
    }

    private void decryption() {
        file =getPathFromUser();
        createAlgorithm();
        File fileDecrypt = new File(AlgorithmOperation.fileExtension(file, 2));
        System.out.println("enter key path");
        myFile = new MyFile("");
        String keyPath = myInput.input();
        DoubleKey doubleKey1 = new DoubleKey();
        doubleKey1 = (DoubleKey)myFile.readObjectFromFile (new File(keyPath));
        System.out.println(doubleKey1.secondKey);
        System.out.println(doubleKey1.firstKey);
        doubleAlgorithm.setKey(doubleKey1.firstKey);
        doubleAlgorithm.decryptFile(file,fileDecrypt,doubleKey1.secondKey);
    }

    private void encryption() {
        file = getPathFromUser();
        createAlgorithm();
        doubleKey = new DoubleKey();
        RandomKey randomKey = new RandomKey();
        doubleKey.firstKey = randomKey.getKey();
        doubleKey.secondKey= randomKey.getKey();
        doubleAlgorithm.setKey(doubleKey.secondKey);
        String prefix1 = file.getPath().substring(0, file.getPath().lastIndexOf('.'))+"key1.bin";
        File fileKey1 = new File(prefix1);
        MyFile myFile = new MyFile("");
        myFile.writeObjectToFile(fileKey1,doubleKey);
        System.out.println(doubleKey.firstKey);
        System.out.println(doubleKey.secondKey);
        File fileEncrypt = new File(AlgorithmOperation.fileExtension(file,1 ));
        doubleAlgorithm.encryptFile(file,fileEncrypt, doubleKey.firstKey);
    }

    private void createAlgorithm() {
         doubleAlgorithm= new Double(new Xor(myInput,myOutput),new Reverse(myInput,myOutput,
                new Double(new Caesar(myInput,myOutput),new Multiplication(myInput,myOutput))));
    }

    // פונקציה שקולטת את הנתיב מהמשתמש
    public File getPathFromUser() {
        myOutput.output("Enter a file path:");
        filePathString = myInput.input();
        while (!(myFileOperations.checkpath(filePathString))) {
            filePathString = myInput.input();
        }
       return file = new File(filePathString);
    }



    public int enterKey() {
        myOutput.output("Enter the encryption key");
        String k = myInput.input();
        return Integer.valueOf(k);//פונקצית המרה מסטרינג לאינט
    }



    @Override
    public void StartDetect() {
        myOutput.output("the cipher is start \nthe time now is" + System.nanoTime());
    }

    @Override
    public void EndDetect() {
        myOutput.output("the cipher is end \nthe time now is" + System.nanoTime());
    }

}



