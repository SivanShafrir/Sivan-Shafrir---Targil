package com.company;

import java.io.File;
import java.io.IOException;


/**
 * Created by Siven on 20/03/2017.
 */
public class Menu {

    public static final int ENCRYPTION = 1;
    public static final int DECRYPTION = 2;
    private Input input;
    private Output output;
    private RandomKeyGenerator randomKey;
    private EncryptionDecryptionListener encryptionListener ;

    public Menu(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.encryptionListener = new EncryptionDecryptionListener(output);
        this.randomKey=new RandomKeyGenerator();
    }


    public String getInitialInstructions(){
        return "please choose:\n 1 for encryption \n 2 for  decryption \n exit for Exit";
    }

    public void start(){
        String userInput=null;
        if(input != null && output !=null){
            output.output(getInitialInstructions());
            while (!((userInput=input.input()).equals("exit"))){
                processInput(userInput);
            }
        }
    }

    public void processInput(String inputFromUser){

        int choose = Integer.valueOf(inputFromUser);
        AlgorithmOperation cipher=null;
        AlgorithmOperation reverseAlgorithm=null;
        FileEncryptorDecryptor encryptor = new FileEncryptorDecryptor();

        CreateKeysFile createKeysFile=new CreateKeysFile();
        try{
            if(choose ==ENCRYPTION){
                encryptionListener.onStart();
                File keysFile = getFile(true);
                DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> keys = createKeysFile.createKey();
                createKeysFile.writeKey(keys, keysFile);

                Key<Integer> key1 = keys.getKey1();
                Key<Integer> key2 = keys.getKey2().getKey1();
                Key<Integer> key3 = keys.getKey2().getKey2();

                printKeys(key1,key2,key3);

                reverseAlgorithm=new Reverse(new Double( new Caesar( key1),  new Multiplication( key3 )));
                cipher=new Double(new Xor(key2),  reverseAlgorithm);
                File fileFromUser=getFile(false);
                encryptor.encryptFile(fileFromUser, cipher);
                encryptionListener.onEnd();

            }else if(choose==DECRYPTION){

                encryptionListener.onStart();
                File keysFile = getFile(true);
                DoubleKey<Key<Integer>, DoubleKey<Key<Integer>, Key<Integer>>> keys = createKeysFile.getKey(keysFile);
                Key<Integer> key1 = keys.getKey1();
                Key<Integer> key2 = keys.getKey2().getKey1();
                Key<Integer> key3 = keys.getKey2().getKey2();

                printKeys(key1,key2,key3);

                reverseAlgorithm=new Reverse(new Double( new Caesar(key1 ), new Multiplication( key3  )));
                cipher = new Double( new Xor(key2  ), reverseAlgorithm);
                File fileFromUser=getFile(false);
                encryptor.decryptFile(fileFromUser, cipher);
                encryptionListener.onEnd();
            }

            start();
        } catch (InvalidKeyException e){
            output.output(e.getMessage());
        }catch (IOException e){
            output.output(e.getMessage());
        }
        catch (ClassNotFoundException e){
            output.output(e.getMessage());
        }
        catch (Exception e){
            output.output("error!");
        }
    }

    public File getFile(boolean isKeyFile){
        if (isKeyFile)
            output.output("enter path of Key File");
        else
            output.output("enter path of encrypt \\ decrypt File");
        String path=input.input();
        HandlerFile file = new HandlerFile(path);
        boolean isValidPath = file.checkFile();
        if (!isValidPath) {
            output.output("is not file or file not exists. please enter path again.");
            getFile(isKeyFile);
        }
        return file;
    }

    public void printKeys(Key<Integer> key1, Key<Integer> key2, Key<Integer> key3){
        output.output("key1: "+ key1.getKeyValue());
        output.output("key2: "+ key2.getKeyValue());
        output.output("key3: "+ key3.getKeyValue());
    }

}
