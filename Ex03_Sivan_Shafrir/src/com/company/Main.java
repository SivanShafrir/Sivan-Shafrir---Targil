package com.company;

public class Main {
    public static void main(String[] args) {
        Menu myMenu = new Menu(new ScreenOutput(),new ScreenInput());
        myMenu.printMenu();
    }
}
