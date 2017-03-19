package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Menu {

    Output myOutput;
    Input myInput;
    FileOperations myFileOperations = new FileOperations();
    EncryptFile encryptFile;// = new EncryptFile(myOutput,myInput);
    DecryptFile decryptFile;// = new DecryptFile(myOutput,myInput);
    String filePathString;
    File filePath;

   /* public Menu () {
        myOutput = new ScreenOutput();
         myInput = new ScreenInput();
        encryptFile = new EncryptFile(myOutput,myInput);
        decryptFile = new DecryptFile(myOutput,myInput);
    }*/

    public Menu(Output myOutput, Input myInput) {
        this.myOutput = myOutput;
        this.myInput = myInput;
         encryptFile = new EncryptFile(myOutput,myInput);
         decryptFile = new DecryptFile(myOutput,myInput);
    }

    public void printMenu() {
        myOutput.output("please choose:\n 1. If you want to encrypt the file Press 1\n 2. If you want to decrypt the file Press 2\n 0. exit\n your choice:\n");
        myChoice();
       // chooseOption();
    }

   /* public void chooseOption() {
        String input;
        while (!(input = myInput.input()).equals("0")) {
            myOutput.output(myChoice(input));
            printMenu();
        }
    }*/


    public void myChoice() {
        String input;
        input = myInput.input();
        if (input.length() != 0) {
            switch (input) {
                case "1":
                    getPathFromUser();
                    myOutput.output(encryptFile.crypt(filePath));
                    break;
                case "2":
                    getPathFromUser();
                    myOutput.output(decryptFile.crypt(filePath));
                    break;
                case "0":
                    myOutput.output("Exit");
                    //return;
                default: {
                    myOutput.output("invalid option. try again.");
                   // return;
                }
            }
        }
        else {
            myOutput.output("Something went wrong. Please try again");
            return;
        }
       printMenu();
    }

    // פונקציה שקולטת את הנתיב מהמשתמש
    public void getPathFromUser() {
        myOutput.output("Enter a file path:");
        filePathString = myInput.input();
        while (!(myFileOperations.checkpath(filePathString))) {
            filePathString = myInput.input();
        }
        filePath = new File(filePathString);
    }

}


