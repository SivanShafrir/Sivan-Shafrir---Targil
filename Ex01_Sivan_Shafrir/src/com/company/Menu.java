package com.company;

/**
 * Created by hackeru on 2/28/2017.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    FileOperations myFileOperations = new FileOperations();
    EncryptFile encryptFile = new EncryptFile();
    DecryptFile decryptFile = new DecryptFile();
    String filePathString;
    File filePath;


    public void printMenu() {
        System.out.println();
        System.out.println("please choose:");
        System.out.println("1. If you want to encrypt the file Press 1");
        System.out.println("2. If you want to decrypt the file Press 2");
        System.out.println("0. exit");
        System.out.println("your choice: ");
        myChoice();

    }

    public  void myChoice(){
        String input = readInput();
        if (input.length() != 0) {
            switch (input) {
                case "1":
                    System.out.println("Enter a file path:");
                    filePathString = Menu.readInput();
                    if(myFileOperations.checkpath(filePathString)) {
                        filePath = new File(filePathString);
                        encryptFile.crypt(filePath);//FileOperations.filePath
                    }
                    break;
                case "2":
                    System.out.println("Enter a file path:");
                    filePathString = Menu.readInput();
                    if(myFileOperations.checkpath(filePathString)){
                        filePath = new File(filePathString);
                        decryptFile.crypt(filePath);//FileOperations.filePath
                    }

                    break;

                case "0":
                    System.out.println("bye bye.");
                    return;
                default:
                    System.out.println("invalid option. try again.");
            }
        }
        printMenu();
    }

    public static String readInput(){
        String input = null;
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }


}
