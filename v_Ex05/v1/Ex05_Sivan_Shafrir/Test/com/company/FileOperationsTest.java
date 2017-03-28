package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hackeru on 3/14/2017.
 */
class FileOperationsTest {

    @BeforeEach
    void setUp() {
        System.out.println("Begin test FileOperations ");

    }

    @AfterEach
    void tearDown() {
        System.out.println("After test FileOperations ");

    }

    //לא נתיב
    @Test
    void checkpathTest_NotPath() {
        FileOperations file = new FileOperations();
        if (file.checkpath("jhgfol"))
            Assertions.fail("is not path");

    }

    //נתיב אבל לא של קובץ (אלא תקיה)
    @Test
    void checkpathTest_NotFile() {
        FileOperations file = new FileOperations();
        if (file.checkpath("C:\\Users\\hackeru\\Documents\\GitHub\\Sivan-Shafrir---Targil"))
            Assertions.fail("is not file");

    }

    //נתיב לא קיים
    @Test
    void checkpathTest_PathNotExsit() {
        FileOperations file = new FileOperations();
        if (file.checkpath("C:\\Users\\hackeru\\Documents\\GitHub\\dgsdgs"))
            Assertions.fail("Path does not exist");
    }

    //נתיב נכון, בודקים אם לא הוחזר פולס
    @Test
    void checkpathTest_Path() {
        FileOperations file = new FileOperations();
        if ((file.checkpath("C:\\Users\\hackeru\\Documents\\GitHub\\Sivan-Shafrir---Targil\\sivan.txt")) == false)
            Assertions.fail("An error was to restore the true");
    }


}