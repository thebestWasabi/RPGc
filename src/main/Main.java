package main;

import main.characters.Goblin;

public class Main {

    public static void main(String[] args) {

        Goblin goblin1 = new Goblin("Гоблин #1", 2, 5, 3, 10, 0, 2);
        System.out.println(goblin1.getRandom());
        System.out.println(goblin1);
    }
}
