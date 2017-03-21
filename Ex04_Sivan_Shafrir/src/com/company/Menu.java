package com.company;

import java.io.File;
import java.util.Random;

/**
 * Created by hackeru on 3/15/2017.
 */
public class Menu implements AlgorithmOperation.Listener {

    Output myOutput;
    Input myInput;
    FileOperations myFileOperations = new FileOperations();
    Operations operations;
    String filePathString;
    File filePath;


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
                case "1":
                    getPathFromUser();
                    operations= chooseAlgoritem();
                    operations.encryptFile(filePath, keyLottery());
                    break;
                case "2":
                    getPathFromUser();
                    operations= chooseAlgoritem();
                    operations.decryptFile(filePath, enterKey());
                    break;
                case "0":
                    myOutput.output("Exit");
                    return;
                default: {
                    myOutput.output("invalid option. try again.");
                }
            }
        } else {
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

    public int keyLottery() {
        Random random = new Random(System.currentTimeMillis());
        int key = random.nextInt(255);
        myOutput.output("The key is:" + key);
        return key;
    }

    public int enterKey() {
        myOutput.output("Enter the encryption key");
        String k = myInput.input();
        return Integer.valueOf(k);//פונקצית המרה מסטרינג לאינט
    }

    //לא להחזיר נאל
    public Operations chooseAlgoritem() {
        myOutput.output("please choose algorithm:\n 1.Caesar\n 2.Xor\n 3.Reverse\n");
        String input;
        input = myInput.input();
        if (input.length() != 0) {
            switch (input) {
                case "1":
                    return new Caesar(myInput, myOutput);
                case "2":
                    return new Xor(myInput, myOutput);
                case "3":
                    return chooseAlgorithmForReverse();
                    // return new Reverse(myInput, myOutput, chooseAlgorithmForReverse());
                default: {
                    myOutput.output("invalid option. try again.");
                   // chooseAlgoritem();
                }
            }
        }
        return  chooseAlgoritem();
    }

    //ליצור את האובייקט מסוג רוורס פה
   public Operations chooseAlgorithmForReverse(){
       myOutput.output("please choose algorithm:\n 1.Caesar\n 2.Xor\n ");
       String input;
       input = myInput.input();
       if (input.length() != 0) {
           switch (input) {
               case "1":
                   return new Reverse(myInput, myOutput,new Caesar(myInput, myOutput));
               case "2":
                   return new Reverse(myInput, myOutput,new Xor(myInput, myOutput));
               default:
                   myOutput.output("invalid option. try again.");

           }
       }
       return chooseAlgorithmForReverse();
    }

    @Override
    public void startEncrypt() {
        myOutput.output("started Encryption"+System.nanoTime());
    }

    @Override
    public void finishEncrypt() {
        myOutput.output("finish Encryption"+System.nanoTime());
    }

    @Override
    public void startDecrypt() {
        myOutput.output("started Decryption"+System.nanoTime());
    }

    @Override
    public void finishDecrypt() {
        myOutput.output("finished Decryption"+System.nanoTime());
    }
}


