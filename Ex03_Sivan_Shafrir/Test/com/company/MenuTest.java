package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by hackeru on 3/16/2017.
 */


//לתקן את הטסטים שיתמכו בפעולה של הקוד.

class MenuTest {

    int outputCount = 0;
    Menu myMenu;

    @BeforeEach
    void setUp() {
        System.out.println("Begin test Menu");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After test Menu");
    }

    @Test
    void printMenu() {
        //  mock()
    }

    @Test
    void chooseOptionTest(){
        Input input = mock(Input.class);
        when(input.input()).thenReturn("1").thenReturn("C:\\Users\\hackeru\\Documents\\GitHub\\Sivan-Shafrir---Targil\\sivan.txt").thenReturn("0");
        Output output = new Output() {
            @Override
            public void output(String s) {
                switch (outputCount){
                    case 0:
                        assertEquals("please choose:\n 1. If you want to encrypt the file Press 1\n 2. If you want to decrypt the file Press 2\n 0. exit\n your choice:\n", s);
                        break;
                    case 1:
                        assertEquals("Enter a file path:", s);
                        break;
                    case 2:

                        assertEquals("The key is:" + myMenu.encryptFile.getKey(), s);
                        break;
                    case 3:
                        assertEquals("Encrypt", s);
                        break;
                }
                outputCount++;
            }
        };
       // EncryptFile encryptFile = new EncryptFile(output,input);
        myMenu = new Menu(output,input);
        myMenu.printMenu();
    }



    @Test
    void myChoiceTest1() {
        Input input = mock(Input.class);
        Output output = mock(Output.class);
        Menu myMenu1 = new Menu(output,input);
        when(input.input()).thenReturn("").thenReturn("0");
        myMenu1.myChoice();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("Something went wrong. Please try again");

       // Assertions.assertEquals(myMenu.myChoice(""), "Something went wrong. Please try again", "assertion failed for blank");
    }
    @Test
    void myChoiceTest2() {
        Input input = mock(Input.class);
        Output output = mock(Output.class);
        Menu myMenu1 = new Menu(output,input);
        when(input.input()).thenReturn("\n").thenReturn("0");
        myMenu1.myChoice();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("invalid option. try again.");
       // Assertions.assertEquals(myMenu.myChoice("\n"), "invalid option. try again.", "assertion failed for Enter");
    }

    @Test
    void myChoiceTest3() {
        Input input = mock(Input.class);
        Output output = mock(Output.class);
        Menu myMenu1 = new Menu(output,input);
        when(input.input()).thenReturn("a").thenReturn("0");
        myMenu1.myChoice();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("invalid option. try again.");
      //  Assertions.assertEquals(myMenu.myChoice("a"), "invalid option. try again.", "assertion failed for letter");
    }

    @Test
    void myChoiceTest4() {
        Input input = mock(Input.class);
        Output output = mock(Output.class);
        Menu myMenu1 = new Menu(output,input);
        when(input.input()).thenReturn("a").thenReturn("6");
        myMenu1.myChoice();
        InOrder orderedOutput = inOrder(output);
        orderedOutput.verify(output).output("invalid option. try again.");
       // Assertions.assertEquals(myMenu.myChoice("6"), "invalid option. try again.", "assertion failed for number except 1,2");
    }


    @Test
    void getPathFromUser() {

    }

}